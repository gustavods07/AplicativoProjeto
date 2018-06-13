package com.example.gustavo.aplicativo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainLogin extends AppCompatActivity {

    private EditText editEmailLogar, editSenhaLogar;
    private Button btnEntrar;
    private TextView txtCadastro;

    private String HOST = "http://10.15.10.70/login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_login);

        editEmailLogar = (EditText) findViewById(R.id.editEmailLogar);
        editSenhaLogar = (EditText) findViewById(R.id.editSenhaLogar);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);

        txtCadastro = (TextView) findViewById(R.id.txtCadastro);

        txtCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abreCad = new Intent(MainLogin.this,MainCadastro.class);
                startActivity(abreCad);
            }
        });

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String email = editEmailLogar.getText().toString();
                String senha = editSenhaLogar.getText().toString();

                String URL =  HOST + "/logar.php";

                if(email.isEmpty() || email.isEmpty() || senha.isEmpty()){
                    Toast.makeText(MainLogin.this, "Nenhum campo deve permanecer vazio", Toast.LENGTH_LONG).show();


                } else {


                    Ion.with(MainLogin.this)
                            .load(URL)
                            .setBodyParameter("email_app", email)
                            .setBodyParameter("senha_app", senha)
                            .asJsonObject()
                            .setCallback(new FutureCallback<JsonObject>() {
                                @Override
                                public void onCompleted(Exception e, JsonObject result) {

                                    try {

                                        //Toast.makeText(MainCadastro.this, "Nome: " + result.get("NOME").getAsString(), Toast.LENGTH_LONG).show();
                                        String RETORNO = result.get("LOGIN").getAsString();

                                        if(RETORNO.equals("ERRO")){

                                            Toast.makeText(MainLogin.this, "Ops, email e/ou senha incorreto(s)" , Toast.LENGTH_LONG).show();


                                        } else if(RETORNO.equals("SUCESSO")){

                                            Intent abrePrincipal = new Intent(MainLogin.this, MainPrincipal.class);
                                            startActivity(abrePrincipal);

                                        } else {

                                            Toast.makeText(MainLogin.this, "Ops,  ocorreu um erro!   " , Toast.LENGTH_LONG).show();


                                        }

                                    } catch (Exception erro) {

                                        Toast.makeText(MainLogin.this, "Ops, ocorreu um erro, " + erro, Toast.LENGTH_LONG).show();

                                    }
                                }
                            });

                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }
}
