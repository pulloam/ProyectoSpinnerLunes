package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilNombre;
    private Button btnAceptar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referencias();
        eventos();
    }

    private void mostrarNombreEnOtraActividad(){
        Comuna comunaUno = new Comuna();

        comunaUno.setNombre("Quinta Normal");
        comunaUno.setPoblacion(10000);
        comunaUno.setAlcalde("Juanito Perez");
        comunaUno.setGrupoGSE("C2");
        comunaUno.setMt2(20000.76f);
        comunaUno.setDireccionMunicipalidad("Los pinos oriente 1234");


        String nombre = tilNombre.getEditText().getText().toString();

        Intent segundaPantalla = new Intent(this,SegundaActividad.class);
        segundaPantalla.putExtra("datoNombre", nombre);
        segundaPantalla.putExtra("datosComuna", comunaUno);

        startActivity(segundaPantalla);
    }



    //region Eventos y referencias
    private void eventos(){
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarNombreEnOtraActividad();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void referencias(){
        tilNombre = findViewById(R.id.tilNombre);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }
    //endregion
}