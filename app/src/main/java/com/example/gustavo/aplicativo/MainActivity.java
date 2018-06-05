package com.example.gustavo.aplicativo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Consultar(View view){

        Intent intent1 = new Intent(getApplicationContext(),TelaVerProdutos.class);
        startActivity(intent1);

    }
    public void Adicionar(View view ){

        Intent intent2 = new Intent(getApplicationContext(),MainLogin.class);
        startActivity(intent2);

    }
}
