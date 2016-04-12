package labpi.convenios.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import labpi.convenios.androidapp.R;
import labpi.convenios.model.Convenio;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView description;

        public ViewHolder(CardView card) {
            super(card);
            this.title = (TextView) card.findViewById(R.id.title);
            this.description = (TextView) card.findViewById(R.id.description);
        }
    }


    private List<Convenio> data;

    public CardListAdapter(List<Convenio> data) {
        this.data = data;
    }

    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView view = (CardView) inflater.inflate(R.layout.card_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Convenio rowData = this.data.get(position);
        holder.title.setText(rowData.getObjetivo());
        holder.description.setText(rowData.getJustificativa());
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
