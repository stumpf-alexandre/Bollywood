package com.stumpf.als.bollywood;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmesAdapter extends ArrayAdapter<ItemFilme> {
    private static final int VIEW_TYPE_DESTAQUE = 0;
    private static final int VIEW_TYPE_ITEM = 1;
    public FilmesAdapter(Context context, ArrayList<ItemFilme> filmes){
        super(context, 0, filmes);
    }
    public static class ItemFilmeHolder{
        TextView titulo;
        TextView desc;
        TextView data;
        RatingBar avaliacao;
        ImageView imagem;
        public ItemFilmeHolder(View view){
            titulo = view.findViewById(R.id.titulo);
            desc = view.findViewById(R.id.descricao);
            data = view.findViewById(R.id.data);
            avaliacao = view.findViewById(R.id.avaliacao);
            imagem = view.findViewById(R.id.imagem);
        }
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);
        ItemFilme filme = getItem(position);
        View itemView = convertView;
        switch (viewType){
            case VIEW_TYPE_DESTAQUE:{
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_fime_destaque, parent, false);
                TextView descricao = itemView.findViewById(R.id.principal_desc);
                descricao.setText(filme.getDescricao());
                RatingBar avaliacao = itemView.findViewById(R.id.principal_avaliacao);
                avaliacao.setRating(filme.getAvaliacao());
                break;
            }
            case VIEW_TYPE_ITEM:{
                itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme, parent, false);
                ItemFilmeHolder holder;
                if (itemView.getTag() == null){
                    holder = new ItemFilmeHolder(itemView);
                    itemView.setTag(holder);
                }
                else {
                    holder = (ItemFilmeHolder) itemView.getTag();
                }
                holder.titulo.setText(filme.getTitulo());
                holder.desc.setText(filme.getDescricao());
                holder.data.setText(filme.getData());
                holder.avaliacao.setRating(filme.getAvaliacao());
                break;
            }
        }
        //if (itemView == null){
            //itemView = LayoutInflater.from(getContext()).inflate(R.layout.item_filme, parent, false);
        //}
        //TextView titulo = itemView.findViewById(R.id.titulo);
        //titulo.setText(filme.getTitulo());
        //TextView descricao = itemView.findViewById(R.id.descricao);
        //descricao.setText(filme.getDescricao());
        //TextView data = itemView.findViewById(R.id.data);
        //data.setText(filme.getData());
        //RatingBar avaliacao = itemView.findViewById(R.id.avaliacao);
        //avaliacao.setRating(filme.getAvaliacao());
        return itemView;
    }
    @Override
    public int getItemViewType(int position) {
        return (position == 0 ? VIEW_TYPE_DESTAQUE : VIEW_TYPE_ITEM);
    }
    @Override
    public int getViewTypeCount() {
        return 2;
    }
}
