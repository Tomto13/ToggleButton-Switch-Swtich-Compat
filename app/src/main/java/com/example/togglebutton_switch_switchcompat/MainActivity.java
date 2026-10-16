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
        //Incializacion del boton
        toggleButton = findViewById(R.id.toggleButton);
        textoSalida = findViewById(R.id.txtSalida);
        switchN = findViewById(R.id.switchN);
        switchCompat = findViewById(R.id.switchCompat);
        imageView = findViewById(R.id.imageView);


        if (toggleButton.isChecked()) {
            textoSalida.setVisibility(TextView.VISIBLE);
        } else {
            textoSalida.setVisibility(TextView.INVISIBLE);
        }
        int currentNightMode = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK;

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
                    //Cuando esta activo
                    textoSalida.setVisibility(TextView.VISIBLE);
                }else{
                    //Cuando esta inactivo
                    textoSalida.setVisibility((TextView.INVISIBLE));
                }
            }
        });

        switchN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode((AppCompatDelegate.MODE_NIGHT_NO));
                }

            }
        });

        switchCompat.setOnCheckedChangeListener((new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    imageView.setVisibility(ImageView.VISIBLE);
                } else{
                    imageView.setVisibility(ImageView.INVISIBLE);
                }
            }
        }));




    }




}