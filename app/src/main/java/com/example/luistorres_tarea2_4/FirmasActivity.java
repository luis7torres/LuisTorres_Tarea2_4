package com.example.luistorres_tarea2_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.luistorres_tarea2_4.clases.Firmas;
import com.example.luistorres_tarea2_4.tablas.Transacciones;

import java.util.ArrayList;
import java.util.List;

public class FirmasActivity extends AppCompatActivity {

    RecyclerView recycler;

    ArrayList<Firmas> ListaFirmas;
    List<Firmas> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firmas);

        ListaFirmas = new ArrayList<>();

        GetListGallery();

        recycler = (RecyclerView) findViewById(R.id.list);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        FirmaAdapter adapter = new FirmaAdapter(items);
        recycler.setAdapter(adapter);
    }

    private void GetListGallery() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();
        Firmas Items = null;
        ListaFirmas = new ArrayList<Firmas>();

        Cursor cursor = db.rawQuery("SELECT * FROM " + Transacciones.tabla_firmas, null);

        while (cursor.moveToNext()) {
            Items = new Firmas();
            Items.setId(cursor.getInt(0));
            Items.setImage(cursor.getBlob(1));
            Items.setDescripcion(cursor.getString(2));

            ListaFirmas.add(Items);
        }

        cursor.close();
        GalleryList();
    }

    private void GalleryList() {

        items = new ArrayList<>();

        for (int i = 0;  i < ListaFirmas.size(); i++){

            items.add(new Firmas(
                    ListaFirmas.get(i).getId(),
                    ListaFirmas.get(i).getImage(),
                    ListaFirmas.get(i).getDescripcion()));
        }
    }
}