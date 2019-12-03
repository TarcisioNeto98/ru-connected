package com.tarcisio.ruconnected;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.tarcisio.ruconnected.Model.Comida;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class LineAdapter extends RecyclerView.Adapter<LineHolder> {

    private final List<Comida> comidas;

    public LineAdapter(ArrayList comida) {
        this.comidas = comida;
    }

    @Override
    public LineHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customrecycler, parent, false));
    }

    @Override
    public void onBindViewHolder(LineHolder holder, int position) {
        holder.title.setText(String.format(Locale.getDefault(), "%s",
                comidas.get(position).getNome()
        ));

        holder.moreButton.setOnClickListener(view -> updateItem(position));
        holder.deleteButton.setOnClickListener(view -> removerItem(position));


    }

    @Override
    public int getItemCount() {
        return comidas != null ? comidas.size() : 0;
    }

    public void updateList(Comida comida) {
        insertItem(comida);
    }

    public void insertItem(Comida comida) {
        comidas.add(comida);
        notifyItemInserted(getItemCount());
    }

    public Comida getItem(int i){
        return comidas.get(i);
    }

    public int tamanho(){
        return comidas.size();
    }

    private void updateItem(int position) {
        Comida comida = comidas.get(position);
        notifyItemChanged(position);
    }

    private void removerItem(int position) {
        Comida comida = comidas.get(position);
        comidas.remove(comida);
        notifyDataSetChanged();
    }

}
