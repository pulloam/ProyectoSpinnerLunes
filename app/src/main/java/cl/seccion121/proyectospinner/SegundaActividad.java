package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SegundaActividad extends AppCompatActivity {
    private TextView tvNombre, tvComuna, tvPoblacion;
    private Button btnVolver;
    private Spinner spnNombres;
    private ListView ltvComuna;
    private Switch swtHablitar;

    private ArrayAdapter<String> adaptadorNombresArreglo;
    private ArrayAdapter<Comuna> adaptadorComunasLista;

    private String[] losNombresArreglo;
    private ArrayList<Comuna> losComunasLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_actividad);

        referencias();
        obtenerDatos();
        eventos();

        adaptadorNombresArreglo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, losNombresArreglo);
        spnNombres.setAdapter(adaptadorNombresArreglo);

        adaptadorComunasLista = new ArrayAdapter<Comuna>(this, android.R.layout.simple_list_item_1, losComunasLista);
        ltvComuna.setAdapter(adaptadorComunasLista);
    }

    private void obtenerDatos() {
        String nombre = getIntent().getExtras().getString("datoNombre");
        Comuna comuna = (Comuna) getIntent().getExtras().getSerializable("datosComuna");
        //String nombreComuna = getIntent().getExtras().getString("nombreComuna");
        //int poblacionComuna = getIntent().getExtras().getInt("poblacionComuna");
        //tvComuna.setText(nombreComuna);
        //tvPoblacion.setText(String.valueOf(poblacionComuna));

        tvNombre.setText(nombre);
        tvComuna.setText(comuna.getNombre());
        tvPoblacion.setText(String.valueOf(comuna.getPoblacion()));


        losNombresArreglo[0] = "Juanito";
        losNombresArreglo[1] = "Maria";
        losNombresArreglo[2] = "Emilia";
        losNombresArreglo[3] = "Valentina";
        losNombresArreglo[4] = "Pablo";

        for(int x = 0; x <= 1000; ++x){
            Comuna c = new Comuna();
            c.setNombre("Comuna " + x);
            c.setPoblacion(1200 + x);
            c.setAlcalde("El alcalde " + x);
            c.setGrupoGSE("GSE " + x);
            losComunasLista.add(c);
        }

        Log.d("TAG_", "Alcalde " + comuna.getAlcalde());
        Log.d("TAG_", "Dirección " + comuna.getDireccionMunicipalidad());
    }

    //region Referencias y eventos

    private void referencias() {
        tvNombre = findViewById(R.id.tvNombre);
        tvComuna = findViewById(R.id.tvComuna);
        tvPoblacion = findViewById(R.id.tvPoblacion);
        btnVolver = findViewById(R.id.btnVolver);
        spnNombres = findViewById(R.id.spnNombres);
        ltvComuna = findViewById(R.id.ltvnombres);
        swtHablitar = findViewById(R.id.swtHabilitar);

        losNombresArreglo = new String[5];
        losComunasLista = new ArrayList<Comuna>();
    }

    private void eventos(){
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volver();
            }
        });

        swtHablitar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    ltvComuna.setVisibility(View.VISIBLE);
                else
                    ltvComuna.setVisibility(View.INVISIBLE);
            }
        });

        ltvComuna.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int indiceSeleccionado, long id) {
                Comuna comunaSeleccionada = losComunasLista.get(indiceSeleccionado);
                Toast.makeText(SegundaActividad.this, "El alcalde es " + comunaSeleccionada.getAlcalde()
                        , Toast.LENGTH_SHORT).show();


            }
        });

        ltvComuna.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Comuna comunaSeleccionada = losComunasLista.get(position);
                Toast.makeText(SegundaActividad.this, "El GSE es " + comunaSeleccionada.getGrupoGSE()
                        , Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }

    //endregion

    private void volver(){
        finish();
    }
}