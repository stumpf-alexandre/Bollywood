package com.stumpf.als.bollywood;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String KEY_FILME = "FILME";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = findViewById(R.id.list_filmes);
        final ArrayList<ItemFilme> arrayList = new ArrayList<>();
        arrayList.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "10/04/2016", 4.5f));
        arrayList.add(new ItemFilme("Super Man", "Filme de heroi de um criptoniano vivendo no planeta Terra", "09/11/1998", 5));
        arrayList.add(new ItemFilme("Homem Formiga", "Filme de heroi de homem que encolhe", "28/07/2017", 2));
        arrayList.add(new ItemFilme("Liga da Justiça", "Filme de grupo de herois que se juntam para defender o planeta", "03/04/2018", 3.2f));
        arrayList.add(new ItemFilme("Transformer", "Filme de robos alienigenas", "30/12/2011", 3));
        arrayList.add(new ItemFilme("Um Dia a Casa Cai", "Filme de comeia", "06/03/1989", 5));
        arrayList.add(new ItemFilme("Naufrago", "Drama de homem que sobrevive a um desastre de avião e fica isolado a uma ilha remota, lutando por sua sobrevivencia", "30/10/2016", 5));
        arrayList.add(new ItemFilme("Bater ou Correr", "Comedia que se passa no velho oeste", "15/09/1999", 4));
        FilmesAdapter adapter = new FilmesAdapter(this, arrayList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemFilme itemFilme = arrayList.get(position);
                Intent intent = new Intent(MainActivity.this, FilmeDetalheActivity.class);
                intent.putExtra(KEY_FILME, itemFilme);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.atualizar:
                Toast.makeText(this, getString(R.string.atualizar_lista), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}