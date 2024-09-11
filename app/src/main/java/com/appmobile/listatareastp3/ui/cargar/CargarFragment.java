package com.appmobile.listatareastp3.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appmobile.listatareastp3.R;
import com.appmobile.listatareastp3.databinding.FragmentCargarBinding;
import com.appmobile.listatareastp3.databinding.FragmentListarBinding;
import com.appmobile.listatareastp3.ui.listar.ListarAdapter;
import com.appmobile.listatareastp3.ui.listar.ListarViewModel;

import java.util.ArrayList;

public class CargarFragment extends Fragment {

    private CargarViewModel mvC;
    private ListarViewModel mvL;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
      //  return inflater.inflate(R.layout.fragment_cargar, container, false);
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Inicializar los ViewModels en onActivityCreated
        mvC = new ViewModelProvider(requireActivity()).get(CargarViewModel.class);


        // Configurar el listener del botón "Agregar"
        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturar el texto ingresado en etTareaIngresada
                String tareaIngresada = binding.etTareaIngresada.getText().toString();
                binding.etTareaIngresada.setText("");
                System.out.println("cargarFrag tarea");
                System.out.println(tareaIngresada);
                // Llamar al método del ViewModel para cargar la nueva tarea
                mvC.cargarTarea(tareaIngresada);
            }
        });


        mvC.getmErrorMsj().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String msj) {
                binding.tvMsjError.setText(msj);
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Evitar fugas de memoria
        binding = null;
    }

}