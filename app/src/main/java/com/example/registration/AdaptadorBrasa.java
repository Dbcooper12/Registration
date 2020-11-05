package com.example.registration;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class AdaptadorBrasa extends BaseAdapter {

 private static LayoutInflater inflater = null;
 Context context;
 String[][] datos;
 int[] datosImg;

    public AdaptadorBrasa(Context context, String[][] datos, int[] datosImg) {
        this.context = context;
        this.datos = datos;
        this.datosImg = datosImg;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.brazaroja,null);
        TextView titulo = (TextView) vista.findViewById(R.id.brazanombre);
        TextView organizacion = (TextView) vista.findViewById(R.id.brasaOrganizacion);
        TextView precio = (TextView) vista.findViewById(R.id.brazaprecio);
        ImageView imagen = (ImageView) vista.findViewById(R.id.imagenB);
        RatingBar calificacion=(RatingBar) vista.findViewById(R.id.ratingBaraza);
        titulo.setText(datos[i][0]);
        organizacion.setText(datos[i][1]);
        precio.setText("Precio:"+datos[i][2]);
        imagen.setImageResource(datosImg[i]);
        calificacion.setProgress(Integer.valueOf(datos[i][3]));
        imagen.setTag(i);
        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visorImagen = new Intent(context,VisorImagenBrasa.class);
                visorImagen.putExtra("IMG",datosImg[(Integer) view.getTag()]);
                context.startActivity(visorImagen);

            }
        });

        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent visorDetalles = new Intent(context,DetalleBrasaRoja.class);
                visorDetalles.putExtra("PRE", datos[i][2]);
                visorDetalles.putExtra("FEC", datos[i][4]);
                visorDetalles.putExtra("REP", datos[i][5]);
                context.startActivity(visorDetalles);
            }
        });



        return vista;
    }
    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
