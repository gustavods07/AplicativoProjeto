package com.example.gustavo.aplicativo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainCadastro extends AppCompatActivity {

    private EditText editNomeCad, editEmailCad, editSenhaCad, editSenhaConf;
    private Button btnCadastrar;
    private String HOST = "http://10.15.10.70/login";


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

            String nome = editNomeCad.getText().toString();
            String email = editEmailCad.getText().toString();
            String senha = editSenhaCad.getText().toString();
            String confirma = editSenhaConf.getText().toString();

            String URL =  HOST + "/cadastrar.php";

            if(confirma.equals(senha)){


                Ion.with(MainCadastro.this)
                        .load(URL)
                        .asJsonObject()
                        .setCallback(new FutureCallback<JsonObject>() {
                            @Override
                            public void onCompleted(Exception e, JsonObject result) {

                                try{

                                    Toast.makeText(MainCadastro.this, "Nome: " + result.get("NOME").getAsString(), Toast.LENGTH_LONG).show();


                                } catch (Exception erro ) {

                                    Toast.makeText(MainCadastro.this, "Ops, ocorreu um erro, " + erro, Toast.LENGTH_LONG).show();

                                }
                            }
                        });


            } else {

                Toast.makeText(MainCadastro.this, "As senhas não conferem", Toast.LENGTH_LONG).show();

            }




            }
        });

    }
}
