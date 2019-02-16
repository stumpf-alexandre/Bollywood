package com.stumpf.als.bollywood;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
public class MainFragment extends Fragment {
    private int posicaoItem = ListView.INVALID_POSITION;
    private static final String KEY_POSITION = "SELECIONADO";
    private ListView list;
    private boolean useFilmeDestaque = false;
    private FilmesAdapter adapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        list = view.findViewById(R.id.list_filmes);
        final ArrayList<ItemFilme> arrayList = new ArrayList<>();
        arrayList.add(new ItemFilme("Homem Aranha", "Filme de heroi picado por uma aranha", "10/04/2016", 4.5f));
        arrayList.add(new ItemFilme("Super Man", "Filme de heroi de um criptoniano vivendo no planeta Terra", "09/11/1998", 5));
        arrayList.add(new ItemFilme("Homem Formiga", "Filme de heroi de homem que encolhe", "28/07/2017", 2));
        arrayList.add(new ItemFilme("Liga da Justiça", "Filme de grupo de herois que se juntam para defender o planeta", "03/04/2018", 3.2f));
        arrayList.add(new ItemFilme("Transformer", "Filme de robos alienigenas", "30/12/2011", 3));
        arrayList.add(new ItemFilme("Um Dia a Casa Cai", "Filme de comeia", "06/03/1989", 5));
        arrayList.add(new ItemFilme("Naufrago", "Drama de homem que sobrevive a um desastre de avião e fica isolado a uma ilha remota, lutando por sua sobrevivencia", "30/10/2016", 5));
        arrayList.add(new ItemFilme("Bater ou Correr", "Comedia que se passa no velho oeste", "15/09/1999", 4));
        adapter = new FilmesAdapter(getContext(), arrayList);
        adapter.setUseFilmeDestaque(useFilmeDestaque);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemFilme itemFilme = arrayList.get(position);
                Callback callback = (Callback) getActivity();
                callback.onItemSelected(itemFilme);
                posicaoItem = position;
            }
        });
        //não perder a posição na lista
        if (savedInstanceState != null && savedInstanceState.containsKey(KEY_POSITION)){
            posicaoItem = savedInstanceState.getInt(KEY_POSITION);
        }
        return view;
    }
    //não perder a posição na lista
    @Override
    public void onSaveInstanceState(Bundle outState) {
        if (posicaoItem != ListView.INVALID_POSITION){
            outState.putInt(KEY_POSITION, posicaoItem);
        }
        super.onSaveInstanceState(outState);
    }
    //não perder a posição na lista
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        if (posicaoItem != ListView.INVALID_POSITION && list != null){
            list.smoothScrollToPosition(posicaoItem);
        }
        super.onViewStateRestored(savedInstanceState);
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.atualizar:
                Toast.makeText(getContext(), getString(R.string.atualizar_lista), Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public interface Callback {
        void onItemSelected(ItemFilme itemFilme);
    }
    public void setUseFilmeDestaque(boolean useFilmeDestaque) {
        this.useFilmeDestaque = useFilmeDestaque;
        if (adapter != null){
            adapter.setUseFilmeDestaque(useFilmeDestaque);
        }
    }
}