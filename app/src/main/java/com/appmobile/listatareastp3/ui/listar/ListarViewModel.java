package com.appmobile.listatareastp3.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.appmobile.listatareastp3.MainActivity;

import java.util.ArrayList;
import java.util.Collections;

public class ListarViewModel extends AndroidViewModel {

    //mutable para el observer que captura las tareas para mostrarlas
    private MutableLiveData<ArrayList<String>> mLista;


    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<String>> getMlista(){
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }

    public void imprimirLista(){


            // Ordenar la lista si es necesario
            Collections.sort(MainActivity.tareas);

            // Establecer el valor para ser observado
            mLista.setValue(MainActivity.tareas);

    }




}