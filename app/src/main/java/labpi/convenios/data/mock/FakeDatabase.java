package labpi.convenios.data.mock;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import labpi.convenios.model.Convenio;

public class FakeDatabase {

    public static int COLUMN_CONVENIO_ANO = 0;
    public static int COLUMN_CONVENIO_ANO_PROPOSTA = 2;
    public static int COLUMN_CONVENIO_ORGAO = 8;
    public static int COLUMN_CONVENIO_MUNICIPIO = 13;
    public static int COLUMN_CONVENIO_PROPONENTE = 15;
    public static int COLUMN_CONVENIO_PROGRAMA = 19;
    public static int COLUMN_CONVENIO_VALOR_GLOBAL = 31;
    public static int COLUMN_CONVENIO_OBJETIVO = 38;
    public static int COLUMN_CONVENIO_JUSTIFICATIVA = 39;

    public static List<Convenio> dataFromFile(Context context, String fileName) {
        List<Convenio> convenios = new ArrayList<>();
        InputStreamReader is = null;

        try {
            is = new InputStreamReader(context.getAssets().open(fileName));
            BufferedReader br = new BufferedReader(is);
            String line;

            br.readLine();
            while ((line = br.readLine()) != null) {
                Convenio convenio = new Convenio();
                String[] rowData = line.split(";");
                convenio.setAno(sanitizeString(rowData[COLUMN_CONVENIO_ANO]));
                convenio.setAnoProposta(sanitizeString(rowData[COLUMN_CONVENIO_ANO_PROPOSTA]));
                convenio.setOrgao(sanitizeString(rowData[COLUMN_CONVENIO_ORGAO]));
                convenio.setMunicipio(sanitizeString(rowData[COLUMN_CONVENIO_MUNICIPIO]));
                convenio.setProponente(sanitizeString(rowData[COLUMN_CONVENIO_PROPONENTE]));
                convenio.setPrograma(sanitizeString(rowData[COLUMN_CONVENIO_PROGRAMA]));
                convenio.setValorGlobal(sanitizeString(rowData[COLUMN_CONVENIO_VALOR_GLOBAL]));
                convenio.setObjetivo(sanitizeString(rowData[COLUMN_CONVENIO_OBJETIVO]));
                convenio.setJustificativa(sanitizeString(rowData[COLUMN_CONVENIO_JUSTIFICATIVA]));
                convenios.add(convenio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return convenios;
    }

    private static String sanitizeString(String input) {
        String output = input.replace("\"", "").toLowerCase();
        return output.substring(0,1).toUpperCase() + output.substring(1);
    }
}
