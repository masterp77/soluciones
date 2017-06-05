package com.example.marcos.finalandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }

    public void regresar(View v){
        finish();
    }

    private void acercaDe(View view) {
        Intent intent = new Intent( getApplicationContext(), AcercaDe.class );
    }
}
