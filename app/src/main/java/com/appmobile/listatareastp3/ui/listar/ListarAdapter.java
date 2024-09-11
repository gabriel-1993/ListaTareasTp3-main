package com.appmobile.listatareastp3.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appmobile.listatareastp3.MainActivity;
import com.appmobile.listatareastp3.R;


import java.util.ArrayList;
import java.util.List;


public class ListarAdapter  extends RecyclerView.Adapter<ListarAdapter.ViewHolderListar>{

    private ArrayList<String> tareas = MainActivity.tareas;
    private LayoutInflater li;

    public ListarAdapter(ArrayList<String> tareas, LayoutInflater li){
        this.tareas = tareas;
        this.li = li;
    }


    //Es el primer metodo que se va ejecutar y va capturar el  adapter cual es la vista/item asociada
    @NonNull
    @Override
    public ViewHolderListar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //pasamos el item y el contenedor padre para mostrarla y false no hay otra vista asociada
        View view = li.inflate(R.layout.tarjeta, parent,false);
        //viewholder espera una vista
        return new ViewHolderListar(view);
    }

    //elemento que se ejecuta por cada elem de la lista y la setea en un nuevo item
    @Override
    public void onBindViewHolder(@NonNull ViewHolderListar holder, int position) {

        String tarea = tareas.get(position);

        //holder es la vista con la instancia de cada uno de sus componentes ya capturados para poder setearles su contenido string,foto,etc
        holder.tvDescripcion.setText(tarea);


    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    //PUENTE ENTRE XML Y ADAPTAR
    public class ViewHolderListar extends RecyclerView.ViewHolder{

        TextView tvDescripcion;

        public ViewHolderListar(@NonNull View itemView) {
            super(itemView);
            tvDescripcion = itemView.findViewById(R.id.tvTarea);
        }

    }
}
