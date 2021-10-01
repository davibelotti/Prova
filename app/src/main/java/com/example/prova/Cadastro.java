package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cadastro extends AppCompatActivity {

    private Button btnCancela;
    private Button btnConfirma;
    private String txtNomeN;
    private int txtNota1N;
    private int txtNota2N;
    private ArrayList<Aluno> alunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCancela = (Button) findViewById(R.id.btnCancela);
        btnConfirma = (Button) findViewById(R.id.btnInserir);
        txtNomeN = findViewById(R.id.txtNomeN);
        txtNota1N = findViewById(R.id.txtNota1N);
        txtNota2N = findViewById(R.id.txtNota2N);

        Intent i = getIntent();
        ArrayList<String> alunos = i.getStringArrayListExtra("alunos");

        btnCancela.setOnClickListener(new EscutadorCancela());
        btnConfirma.setOnClickListener(new EscutadorConfirma());
    }

    private class EscutadorCancela implements View.OnClickListener{
        @Override
        public void onClick(View view){
            onBackPressed();
        }
    }

    private class EscutadorConfirma implements  View.OnClickListener {
        @Override
        public void onClick(View view){
            String nome;
            int nota1;
            int nota2;

            nome = txtNomeN.getText().ToString();
            nota1 = txtNota1N.getText().ToString();
            nota2 = txtNota2N.getText().ToString();

            Aluno a = new Aluno(nome, nota1, nota2);
            alunos.add(a);

            txtNomeN.setText("");
            txtNota1N.setText("");
            txtNota2N.setText("");

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            i.putStringArrayListExtra("alunos", alunos);

            setResult(RESULT_OK, i);

            finish();
        }
    }
}