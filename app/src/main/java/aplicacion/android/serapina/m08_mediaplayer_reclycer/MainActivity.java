package aplicacion.android.serapina.m08_mediaplayer_reclycer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Hacer referencia a AdapterDatos
    private List<Integer> canciones;
    private RecyclerView mReclycerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mlayoutManager;


    Button btn_Play;
    Button btn_Stop;

    int num_cancion;

    MyMusica myMusica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_Play= findViewById(R.id.btnPlay);
        btn_Stop = findViewById(R.id.btnStop);

        canciones = this.getAllNamnes();

        //canciones.add(R.raw.picenteamigo_amorali);
        //canciones.add(R.raw.pacodelucia_almonte);


        mReclycerView = findViewById(R.id.reclycerId);
        //recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mlayoutManager = new LinearLayoutManager(this);

        mAdapter = new MyAdapter(canciones, R.layout.item_list, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int v, int p) {
                Toast.makeText(MainActivity.this, "" + p, Toast.LENGTH_LONG).show();
                num_cancion = p;
            }
        });

        //recycler.setAdapter(adapter);
        mReclycerView.setLayoutManager(mlayoutManager);
        mReclycerView.setAdapter(mAdapter);

        myMusica = new MyMusica(this,canciones);

    }

    public void push_play(View view){

        myMusica.reproducir(num_cancion);
    }

    public void push_stop(View view){

       myMusica.parar();
    }
    public void push_pause(View view){

        myMusica.pausa();
    }
    public void push_release(View view){

        myMusica.reanudar();
    }

    private List<Integer> getAllNamnes() {
        return new ArrayList <Integer>(){{
            add(R.raw.pacodelucia_almonte);
            add(R.raw.picenteamigo_amorali);
        }};
    }

}
