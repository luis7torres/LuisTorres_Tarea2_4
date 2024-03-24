package com.example.luistorres_tarea2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luistorres_tarea2_4.tablas.Transacciones;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    EditText txt_descripcion;
    Button btn_salvar, btn_verFirmas;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_descripcion = (EditText) findViewById(R.id.txtDescripcion);
        btn_salvar = (Button) findViewById(R.id.btnSalvar);
        btn_verFirmas = (Button) findViewById(R.id.btnVerFirmas);
        view = (View) findViewById(R.id.firmas);

        //Evento para el boton de Salvar
        btn_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveFirma();
            }
        });

        //Evento para el boton de Ver Firmas
        btn_verFirmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FirmasActivity.class);
                startActivity(intent);
            }
        });
    }

    //Metodo para salvar la firma
    public void saveFirma(){

        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        try{

            ContentValues valores = new ContentValues();

            valores.put(Transacciones.imagen, Viewfirma(view));
            valores.put(Transacciones.descripcion, txt_descripcion.getText().toString());

            Long resultado = db.insert(Transacciones.tabla_firmas, Transacciones.id, valores);

            Toast.makeText(getApplicationContext(), "FIRMA INGRESADA: " + resultado.toString(), Toast.LENGTH_LONG).show();
            txt_descripcion.setText("");
            view.setDrawingCacheEnabled(false);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static byte[]  Viewfirma(View view5) {
        view5.setDrawingCacheEnabled(true);
        Bitmap bitmap = view5.getDrawingCache();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);

        byte[] byteArray = stream.toByteArray();
        return byteArray;

    }

    //Metodo para limpiar
    private void ClearScreen() {
        txt_descripcion.setText("");
        view.setDrawingCacheEnabled(false);
    }

}