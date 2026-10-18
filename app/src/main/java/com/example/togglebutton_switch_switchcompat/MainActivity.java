package com.example.togglebutton_switch_switchcompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    TextView textoSalida;
    Switch switchN;
    ImageView imageView;
    SwitchCompat switchCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Declaración de los componentes de la interfaz
        toggleButton = findViewById(R.id.toggleButton); // Botón utilizado para esconder/mostrar el texto
        textoSalida = findViewById(R.id.txtSalida);
        switchN = findViewById(R.id.switchN); // Switch encargado del modo oscuro
        switchCompat = findViewById(R.id.switchCompat); // SwitchCompat encargado de mostrar/ocultar la imagen
        imageView = findViewById(R.id.imageView);

        // Verifica si el ToggleButton ya está activo para mostrar u ocultar el texto
        if (toggleButton.isChecked()) {
            textoSalida.setVisibility(TextView.VISIBLE);
        } else {
            textoSalida.setVisibility(TextView.INVISIBLE);
        }
        // Obtiene la configuración actual del sistema para saber si está activado el modo oscuro
        int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;
        // Sincroniza el switch con el estado actual del sistema sin alterar la preferencia del usuario
        boolean isDarkMode = (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES);

        switchN.setChecked(isDarkMode);

        if(switchCompat.isChecked()){
            imageView.setVisibility(ImageView.VISIBLE);
        } else {
            imageView.setVisibility(ImageView.INVISIBLE);
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //Cuando esta activo muestra el texto
                    textoSalida.setVisibility(TextView.VISIBLE);
                }else{
                    //Cuando esta inactivo oculta el texto
                    textoSalida.setVisibility((TextView.INVISIBLE));
                }
            }
        });

        switchN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //activa el modo oscuro
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    //desactiva el modo oscuro
                    AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
                }

            }
        });

        switchCompat.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    //muestra la imagen
                    imageView.setVisibility(ImageView.VISIBLE);
                } else{
                    //oculta la imagen
                    imageView.setVisibility(ImageView.INVISIBLE);
                }
            }
        }));




    }




}