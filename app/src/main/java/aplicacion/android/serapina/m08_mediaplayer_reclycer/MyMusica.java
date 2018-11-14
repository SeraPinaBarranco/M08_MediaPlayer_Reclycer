package aplicacion.android.serapina.m08_mediaplayer_reclycer;

import android.content.Context;
import android.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MyMusica extends MediaPlayer {
    List<Integer> miList;
    Context context;
    int nCancion;

    MediaPlayer mp = new MediaPlayer();
    private int time;//almacena el tiempo transcurrido de la cancion

    public MyMusica(Context context, List<Integer> miList) {

        this.context = context;
        this.miList = miList;
        //this.nCancion = nCancion;
    }

    public void reproducir(int n){
        //si la cancion no se esta reproduciendo lo hace
        if(!mp.isPlaying()){
            mp = MediaPlayer.create(context,miList.get(n));
            mp.start();
        }
        //si la cancion esta en reproduccion la reanuda
        if(mp != null && mp.isPlaying()){
            mp.seekTo(time);
            mp.start();
        }
    }

    public void parar(){
        if (mp.isPlaying()){
            mp.stop();
            time = 0;
        }

    }

    public void reanudar(){

    }

    public void pausa(){
        if(mp.isPlaying()){
            time = mp.getCurrentPosition();//guarda el tiempo transcurrido de la cancion
            mp.pause();
        }
    }
}
