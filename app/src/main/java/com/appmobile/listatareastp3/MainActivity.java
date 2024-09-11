package com.appmobile.listatareastp3;

import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.appmobile.listatareastp3.databinding.ActivityMainBinding;

import java.util.ArrayList;




/*
Desarrolla una aplicación móvil en Android utilizando el patrón de arquitectura MVVM. La aplicación deberá permitir a los usuarios crear y guardar notas en memoria, es decir, sin necesidad de persistirlas en una base de datos o archivo. La interfaz gráfica de usuario deberá incluir una pantalla principal que muestre una lista de todas las notas existentes. La aplicación deberá implementar el patrón MVVM para separar la lógica de presentación de la lógica de negocio y utilizar LiveData para la comunicación entre las capas de vista y modelo. Además, deberá usar RecyclerView para la implementación de la lista de notas.

Para ello te proponemos crear una Activity principal que será un menú navegable y que poseerá un ArrayList<String> que serán las notas o apuntes, que será pública y estática.

Opciones del Menú:

Cargar: Con una vista que permitirá cargar una nota y agregarla a la lista estática. Informar si se intenta ingresar una cadena vacía.

Listar: Mostrará un RecyclerView con todas las notas agregadas en orden alfabético.

Salir: Que activará un Diálogo que permita el cierre de la aplicación. No utilizar viewModel.

PD: Puede desarrollar esta actividad en grupo, entregando link a repositorio de GitHub y Apellido, Nombre y DNI de los integrantes.

Abierta hasta 11/09/2024 23:59 */







public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    public static ArrayList<String> tareas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityMainBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());

       setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .setAnchorView(R.id.fab).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
               R.id.nav_listar,R.id.nav_cargar, R.id.nav_salir)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}