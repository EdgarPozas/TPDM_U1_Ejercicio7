package com.mycompany.myapp;

import android.app.*;
import android.os.*;
import android.text.*;
import android.widget.*;
import android.view.*;
import android.widget.CompoundButton.*;
import java.io.*;
import android.content.*;

public class MainActivity extends Activity 
{
	private EditText edad;
	private Switch sw;
	private RadioGroup radio;
	private CheckBox c1,c2,c3,c4;
	private Button btn;
	private RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		edad=findViewById(R.id.edad);
		sw=findViewById(R.id.sw);
		radio=findViewById(R.id.radio);
		c1=findViewById(R.id.c1);
		c2=findViewById(R.id.c2);
		c3=findViewById(R.id.c3);
		c4=findViewById(R.id.c4);
		btn=findViewById(R.id.btn);
		r1=findViewById(R.id.r1);
		r2=findViewById(R.id.r2);
		
		sw.setOnCheckedChangeListener(new OnCheckedChangeListener(){
			@Override
			public void onCheckedChanged(CompoundButton c,boolean l){
				edad.setEnabled(l);
				c1.setEnabled(l);
				c2.setEnabled(l);
				c3.setEnabled(l);
				c4.setEnabled(l);
				radio.setEnabled(l);
				r1.setEnabled(l);
				r2.setEnabled(l);
				btn.setEnabled(l);
			}
		});
    }
	public void aceptar(View v){
		if(edad.getText().toString().isEmpty()){
			Toast.makeText(this,"Llene su edad",Toast.LENGTH_SHORT).show();
			return;
		}
		String cad=edad.getText().toString()+"";
		
		if(c1.isChecked())
			cad+=",mexico";
		if(c2.isChecked())
			cad+=",america";
		if(c3.isChecked())
			cad+=",europa";
		if(c4.isChecked())
			cad+=",asia";
		
		if(r1.isChecked())
			cad+=",casado";
		if(r2.isChecked())
			cad+=",soltero";
			
		try{
			OutputStreamWriter ou=new OutputStreamWriter(openFileOutput("archivo.txt",Context.MODE_PRIVATE));
			ou.write(cad);
			ou.close();
			Toast.makeText(this,"Datos guardados en archivo.txt",Toast.LENGTH_SHORT).show();
		}catch(Exception ex){
			Toast.makeText(this,"Error al guardar",Toast.LENGTH_SHORT).show();
			ex.printStackTrace();
		}
	}
}
