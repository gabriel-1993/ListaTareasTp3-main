package com.appmobile.listatareastp3.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.appmobile.listatareastp3.MainActivity;
import com.appmobile.listatareastp3.databinding.FragmentCargarBinding;
import com.appmobile.listatareastp3.databinding.FragmentListarBinding;
import com.appmobile.listatareastp3.ui.listar.ListarViewModel;

import java.util.ArrayList;
import java.util.Collections;

public class CargarViewModel extends AndroidViewModel {

    private FragmentCargarBinding binding;




    private MutableLiveData<String> mErrorMsj;


    // Referencia al ListarViewModel para actualizar la lista de tareas
    private ListarViewModel mvl;

    public CargarViewModel(@NonNull Application application) {
        super(application);


    }



    public MutableLiveData<String> getmErrorMsj(){
        if(mErrorMsj == null){
            mErrorMsj = new MutableLiveData<>();
        }
        return mErrorMsj;
    }

    public void cargarTarea(String tareaNueva) {
        // Verificar si el texto ingresado está vacío
        if (tareaNueva.equals("")) {
            getmErrorMsj().setValue("Debe ingresar un texto.");
            return;
        }


        if (MainActivity.tareas.size()>0 && MainActivity.tareas.contains(tareaNueva)) {
            getmErrorMsj().setValue("La tarea ya existe en la lista.");
        } else {
            getmErrorMsj().setValue("Agregada con exito.");
            // Si no existe, agregar la nueva tarea a la lista
            MainActivity.tareas.add(tareaNueva);

        }
    }


}