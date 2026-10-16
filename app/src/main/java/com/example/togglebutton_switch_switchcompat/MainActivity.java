package com.example.togglebutton_switch_switchcompat;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton;
    private TextView textoSalida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //Incializacion del boton
        toggleButton = findViewById(R.id.toggleButton);
        textoSalida = findViewById(R.id.txtSalida);
        if (toggleButton.isChecked()) {
            textoSalida.setVisibility(TextView.VISIBLE);
        } else {
            textoSalida.setVisibility(TextView.INVISIBLE);
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

    }




}