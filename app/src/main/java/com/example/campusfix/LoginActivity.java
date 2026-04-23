package com.example.campusfix;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText txtEmail, txtClave;
    MaterialButton btnIniciarSesion;

    //Implementar un arreglo para almacenar las credenciales del usuario
    private final String[][] usuarios =
            {
                    {"usuario1@campus.com", "1234"},
                    {"usuario2@campus.com", "5678"},
                    {"usuario3@campus.com", "9999"}
            };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());
            int bottom = Math.max(systemBars.bottom, ime.bottom);
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Enlazar los controles xml con los controles java
        txtEmail = findViewById(R.id.txtEmail);
        txtClave = findViewById(R.id.txtClave);
        btnIniciarSesion = findViewById(R.id.btnIniciarSesion);

        btnIniciarSesion.setOnClickListener(v-> {
            iniciarSesion();
        });
    }

    private boolean validarCredenciales(String email, String clave){
        for(String[] usuario: usuarios){
            if(usuario[0].equals(email) && usuario[1].equals(clave)){
                return true;//credenciales correctas
            }
        }
        return false;
    }

    private void iniciarSesion(){
        String email=txtEmail.getText().toString();
        String clave=txtClave.getText().toString();

        //Validar ingreso de las credenciales
        if(email.isEmpty() || clave.isEmpty()){
            mostrarSnackBar("Complete el email y contraseña", android.R.color.holo_orange_light);
            return;
        }
        //validar ingreso de las credenciales
        if(validarCredenciales(email, clave)){
            Toast.makeText(this, "Bienvenido al sistema", Toast.LENGTH_SHORT).show();
            //Navegar al menú principal
            Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
            startActivity(intent);
        }else{
            mostrarSnackBar("Credenciales incorrectas", android.R.color.holo_red_light);
        }
    }

    private void mostrarSnackBar(String mensaje, int color) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), mensaje, Snackbar.LENGTH_LONG);
        //Personalizar el color del snackbar
        View view = snackbar.getView();
        view.setBackgroundTintList(ContextCompat.getColorStateList(getApplicationContext(), color));
        snackbar.show();
    }

}