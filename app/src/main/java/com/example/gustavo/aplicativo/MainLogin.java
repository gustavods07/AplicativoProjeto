package com.example.gustavo.aplicativo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainLogin extends AppCompatActivity {

    private EditText editEmailLogar, editSenhaLogar;
    private Button btnEntrar;
    private TextView txtCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        txtCadastro = (TextView) findViewById(R.id.txtCadastro);

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCad = new Intent(MainLogin.this,MainCadastro.class);
                startActivity(abreCad);
            }
        });
    }
}
