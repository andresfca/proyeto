package com.example.andres.proyecto;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ANDRES on 13/11/2017.
 */

public class AdaptadorAccesorio extends ArrayAdapter<GridItem>{

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<GridItem> mGridData = new ArrayList<GridItem>();
    private ArrayList<Accesorio> accesorios;

    public AdaptadorAccesorio(Context mContext, int layoutResourceId, ArrayList<GridItem> mGridData,ArrayList<Accesorio> accesorios) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
        this.accesorios=accesorios;
    }
    public void setGridData(ArrayList<GridItem> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        final ViewHolder holder = new ViewHolder();
        //ViewHolder holder2 = new ViewHolder();
        final Accesorio a = accesorios.get(position);
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        storageReference.child(a.getFoto()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.with(mContext).load(uri).into(holder.imageView);
            }
        });
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder.titleTextView = (TextView) row.findViewById(R.id.lblNombre);
            holder.imageView = (ImageView) row.findViewById(R.id.imgAccesorio);
            row.setTag(holder);


        GridItem item = mGridData.get(position);
        Picasso.with(mContext).load(item.getImage()).into(holder.imageView);
        return row;
    }
    static class ViewHolder {
        TextView titleTextView;
        ImageView imageView;
    }
}




    /*private Context context;

    public AdaptadorAccesorio(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return ;
    }

    @Override
    public Accesorio getItem(int i) {
        return Accesorio.ITEMS[i];
    }

    @Override
    public long getItemId(int i) {
        return getItem(i).getIdd();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view==null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view =inflater.inflate(R.layout.item_accesorio,viewGroup,false);
        }
        ImageView imgAccesorio = (ImageView)view.findViewById(R.id.imgAccesorio);
        TextView nombreAccesorio = (TextView)view.findViewById(R.id.lblNombre);

        final Accesorio item = getItem(i);
        imgAccesorio.setImageResource(item.getFoto());
        nombreAccesorio.setText(item.getNombre());
        return view;
    }*/

