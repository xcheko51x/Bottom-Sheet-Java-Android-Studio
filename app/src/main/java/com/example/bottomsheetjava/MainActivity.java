package com.example.bottomsheetjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button btnMuestraBottomSheet;
    TextView tvNombre;
    TextView tvEdad;
    TextView tvPuesto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMuestraBottomSheet = findViewById(R.id.idBtnShowBottomSheet);

        Trabajador trabajador = new Trabajador("Sergio Peralta", 33, "Developer");

        btnMuestraBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BottomSheetDialog dialog = new BottomSheetDialog(MainActivity.this);

                View vista = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet_dialog, null);

                tvNombre = vista.findViewById(R.id.tvNombre);
                tvEdad = vista.findViewById(R.id.tvEdad);
                tvPuesto = vista.findViewById(R.id.tvPuesto);

                tvNombre.setText(trabajador.nombre);
                tvEdad.setText("EDAD: "+trabajador.edad);
                tvPuesto.setText("PUESTO: "+trabajador.puesto);

                dialog.setCancelable(true);
                dialog.setContentView(vista);

                dialog.show();

            }
        });
    }
}