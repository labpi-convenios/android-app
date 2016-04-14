package labpi.convenios.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import labpi.convenios.androidapp.ProjectDescriptionActivity;
import labpi.convenios.androidapp.R;
import labpi.convenios.model.Convenio;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    private List<Convenio> data;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title;
        public TextView description;

        public ViewHolder(CardView card) {
            super(card);
            this.title = (TextView) card.findViewById(R.id.title);
            this.description = (TextView) card.findViewById(R.id.description);
            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ProjectDescriptionActivity.class);
            Convenio selectedItem = data.get(this.getAdapterPosition());

            Bundle args = new Bundle();
            args.putSerializable(ProjectDescriptionActivity.DATA, selectedItem);
            intent.putExtras(args);
            context.startActivity(intent);
        }
    }


    public CardListAdapter(Context context, List<Convenio> data) {
        this.context = context;
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
