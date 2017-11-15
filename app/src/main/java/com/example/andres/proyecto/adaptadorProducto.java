package com.example.andres.proyecto;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;


public class adaptadorProducto extends ArrayAdapter<String>{
    private final Activity context;
    private final String[] item;
    private final Integer[] integers;

    public adaptadorProducto(Activity context, String[] item, Integer[] integers) {
        super(context, R.layout.item_producto, item);
        // TODO Auto-generated constructor stub
        this.context=context;
        this.item=item;
        this.integers=integers;
    }
    public View getView(int posicion, View view, ViewGroup parent){

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_producto,null,true);

        TextView txtTitle = rowView.findViewById(R.id.lblNombre);
        ImageView imageView =  rowView.findViewById(R.id.imgFoto);
        //CircleImageView imageView1 = rowView.findViewById(R.id.imgFoto);

        txtTitle.setText(item[posicion]);
        imageView.setImageResource(integers[posicion]);
        //imageView1.setImageResource(integers[posicion]);

        return rowView;
    }


}
