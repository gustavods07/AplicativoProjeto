package com.example.gustavo.aplicativo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainCadastro extends AppCompatActivity {

    private EditText editNomeCad, editEmailCad, editSenhaCad, editSenhaConf;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_cadastro);

        editNomeCad = (EditText) findViewById(R.id.editNomeCad);
        editEmailCad = (EditText) findViewById(R.id.editEmailCad);
        editSenhaCad = (EditText) findViewById(R.id.editSenhaCad);
        editSenhaConf = (EditText) findViewById(R.id.editSenhaConf);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
