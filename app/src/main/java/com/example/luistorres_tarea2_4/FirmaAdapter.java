package com.example.luistorres_tarea2_4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.luistorres_tarea2_4.clases.Firmas;

import java.util.List;

public class FirmaAdapter extends RecyclerView.Adapter<FirmaAdapter.SignViewHolder>{

    private List<Firmas> items;

    public FirmaAdapter(List<Firmas> items) {
        this.items = items;
    }

    @Override
    public SignViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.viewfirmas, viewGroup, false);
        return new SignViewHolder(v);
    }

    @Override
    public void onBindViewHolder(SignViewHolder viewHolder, int i) {
        Bitmap BMP = BitmapFactory.decodeByteArray(items.get(i).getImage(), 0,items.get(i).getImage().length);

        viewHolder.firma.setImageBitmap(BMP);
        viewHolder.descripcion.setText(items.get(i).getDescripcion());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class SignViewHolder extends RecyclerView.ViewHolder {
        public ImageView firma;
        public TextView descripcion;

        public SignViewHolder(View v) {
            super(v);
            firma = (ImageView) v.findViewById(R.id.viewfirmas);
            descripcion = (TextView) v.findViewById(R.id.descripcion);
        }
    }
}
