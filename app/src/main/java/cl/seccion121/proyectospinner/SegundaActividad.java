package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SegundaActividad extends AppCompatActivity {
    private TextView tvNombre, tvComuna, tvPoblacion;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        tvNombre = findViewById(R.id.tvNombre);
        tvComuna = findViewById(R.id.tvComuna);
        tvPoblacion = findViewById(R.id.tvPoblacion);
        btnVolver = findViewById(R.id.btnVolver);

        String nombre = getIntent().getExtras().getString("datoNombre");
        Comuna comuna = (Comuna) getIntent().getExtras().getSerializable("datosComuna");
        //String nombreComuna = getIntent().getExtras().getString("nombreComuna");
        //int poblacionComuna = getIntent().getExtras().getInt("poblacionComuna");
        //tvComuna.setText(nombreComuna);
        //tvPoblacion.setText(String.valueOf(poblacionComuna));

        tvNombre.setText(nombre);
        tvComuna.setText(comuna.getNombre());
        tvPoblacion.setText(String.valueOf(comuna.getPoblacion()));

        Log.d("TAG_", "Alcalde " + comuna.getAlcalde());
        Log.d("TAG_", "Dirección " + comuna.getDireccionMunicipalidad());


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

    }

    private void volver(){
        finish();
    }
}