package aplicacion.android.serapina.m08_mediaplayer_reclycer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<Integer> names;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapter(List <Integer> names, int layout, OnItemClickListener listener) {
        this.names = names;
        this.layout = layout;
        this.itemClickListener = listener;
    }



    @NonNull
    @Override
    //enlaza este adaptador con el archivo item_list XML
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar el view
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    //establece el enlace entre el adaptador y la clase ViewHolerDatos
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int i) {
        //llamar a metodo propio "asignarDatos"
        viewHolder.bind(names.get(i),itemClickListener);

    }

    @Override
    public int getItemCount() {
        return names.size();
    }

    //////////////////////////////////
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //referenciar controles del layout de que tiene los componentes de la lista
        TextView textViewName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textViewName = itemView.findViewById(R.id.txtCancion);
        }

        public void bind(final Integer datos, final OnItemClickListener listener) {
            this.textViewName.setText(datos);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(datos, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{

        void onItemClick(int v, int p);
    }

}
