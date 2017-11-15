package com.example.andres.proyecto;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;

public class CrearAccesorio extends AppCompatActivity {
    private EditText txtNombre;
    private EditText txtPrecio;
    private Spinner cmbTipo;
    private ArrayList<Integer> fotos;
    private Resources resources;
    private Uri uri;
    private ImageView foto;
    private StorageReference storageReference;
    private String[] strTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_accesorio);

        resources=this.getResources();
        foto = (ImageView)findViewById(R.id.fotoInicial);
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtPrecio=(EditText)findViewById(R.id.txtPrecio);
        cmbTipo=(Spinner)findViewById(R.id.cmbTipo);

        strTipo=resources.getStringArray(R.array.AccesoriosArray);
        ArrayAdapter<String> adapterAccesorio=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,strTipo);
        cmbTipo.setAdapter(adapterAccesorio);

        inicializar_fotos();
        storageReference= FirebaseStorage.getInstance().getReference();
    }

    public void inicializar_fotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.fotoacc);
        fotos.add(R.drawable.fotojueg);
        fotos.add(R.drawable.fotomang);
    }
    public boolean validar(){
        String aux = resources.getString(R.string.MensajeErrorVacio);
        if (Metodos.validar_aux(txtNombre,aux))return false;
        else if (Metodos.validar_aux(txtPrecio,aux))return false;
        return true;
    }
    public void agregar(View v){
        String ti = cmbTipo.getSelectedItem().toString();
        double precio = Double.parseDouble(txtPrecio.getText().toString());
        if(validar()){
            String id = Datos.getId();
            String foto = id+".jpg";
            Accesorio a = new Accesorio(id,ti,txtNombre.getText().toString(),precio,foto);
            a.guardar();
            subir_foto(foto);
            Snackbar.make(v,resources.getString(R.string.Mensaje_accesorio_guardado),Snackbar.LENGTH_SHORT).setAction("Action",null).show();
            limpiar();
        }
    }
    public void subir_foto(String foto){
        StorageReference childRef = storageReference.child(foto);
        UploadTask uploadTask = childRef.putFile(uri);
    }
    public void limpiar(View v){
        limpiar();
    }
    public void limpiar(){
        txtPrecio.setText("");
        txtNombre.setText("");
        cmbTipo.setSelection(0);
        foto.setImageDrawable(ResourcesCompat.getDrawable(resources,android.R.drawable.ic_menu_gallery,null));
        InputMethodManager inputManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromInputMethod(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearAccesorio.this,AgregarAccesorio.class);
        startActivity(i);
    }

    protected void onActivityResult(int requesCode, int resultCode, Intent data){
        super.onActivityResult(requesCode,resultCode,data);
        if (requesCode==1){
            uri = data.getData();
            if (uri!=null){
                foto.setImageURI(uri);
            }
        }
    }
    public void seleccionar_foto(View v){
        Intent i = new Intent();
        i.setType("image/*");
        i.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(i,getString(R.string.Seleccion_imagen)),1);
    }
}
