package com.stumpf.als.bollywood;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FilmeDetalheActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_detalhe);
        Intent intent = getIntent();
        ItemFilme itemFilme = (ItemFilme) intent.getSerializableExtra(MainActivity.KEY_FILME);
        TextView titulo = findViewById(R.id.detalhe_titulo);
        titulo.setText(itemFilme.getTitulo());
        TextView data = findViewById(R.id.detalhe_data);
        data.setText(itemFilme.getData());
        TextView desc = findViewById(R.id.detalhe_desc);
        desc.setText(itemFilme.getDescricao());
        RatingBar avaliacao = findViewById(R.id.detalhe_avaliacao);
        avaliacao.setRating(itemFilme.getAvaliacao());
        Button btn = findViewById(R.id.btn_trailer);
    }
}
