package com.stumpf.als.bollywood;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
public class FilmeDetalheFragment extends Fragment {
    private ItemFilme itemFilme;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            itemFilme = (ItemFilme) getArguments().getSerializable(MainActivity.KEY_FILME);
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filme_detalhe, container, false);
        if (itemFilme == null){
            return view;
        }
        TextView titulo = view.findViewById(R.id.detalhe_titulo);
        titulo.setText(itemFilme.getTitulo());
        TextView data = view.findViewById(R.id.detalhe_data);
        data.setText(itemFilme.getData());
        TextView desc = view.findViewById(R.id.detalhe_desc);
        desc.setText(itemFilme.getDescricao());
        RatingBar avaliacao = view.findViewById(R.id.detalhe_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());
        //API
        ImageView capa = view.findViewById(R.id.detalhe_filme);
        new DownloadImageTask(capa).execute(itemFilme.getCapaPath());
        if (view.findViewById(R.id.item_post) != null){
            ImageView poster = view.findViewById(R.id.item_post);
            new DownloadImageTask(poster).execute(itemFilme.getPosterPath());
        }
        return view;
    }
}