package com.example.campusfix;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.campusfix.databinding.ActivityMenuBinding;

import com.google.android.material.navigation.NavigationView;

public class MenuActivity extends AppCompatActivity {
    //Configuración de la barra superior
    private AppBarConfiguration mAppBarConfiguration;

    //Referencia al binding para enlazar a los controles
    private ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //Inicializar el binding
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Configurar el toolBar
        setSupportActionBar(binding.appBarMenu.toolbar);

        //Referenciar al contenedor del menú y a la vista de navegación
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        //Configurar la barra de navegación
        mAppBarConfiguration = new AppBarConfiguration.Builder
                (
                        R.id.nav_inicio,
                        R.id.nav_ambientes,
                        R.id.nav_tipos_incidencia,
                        R.id.nav_registrar_incidencia,
                        R.id.nav_informes_erroneos,
                        R.id.nav_cambiar_estado,
                        R.id.nav_acerca_de
                ).setOpenableLayout(drawer).build();

        //Gestionar el intercambio de items del menú: Al cambiar de item, cambia de fragment
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);

        //Vincular el toolbar con el NavController y la configuración del drawer
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);

        //Vincular el menú lateral (navigationView) con el NavControler para que al hacer clic en el item quede seleccionado
        NavigationUI.setupWithNavController(navigationView, navController);

        //Gestionar la navegación hacia el menú inicio, cuando se navega hacia otras opciones desde algún botón ubicado en un fragment
        navigationView.setNavigationItemSelectedListener(menuItem -> {
            boolean handled = NavigationUI.onNavDestinationSelected(menuItem, navController);
            if (handled) drawer.closeDrawers();

            if (menuItem.getItemId() == R.id.nav_inicio){
                navController.popBackStack(R.id.nav_inicio, false);//Navega hacia el menú inicio
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
            return handled;
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        //Este evento se ejecuta cuando el usuario hace click en el menú de la esquina superior izquierda
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration) || super.onSupportNavigateUp();
    }
}