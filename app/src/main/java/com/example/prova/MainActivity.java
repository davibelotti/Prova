package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnInserir;
    private ListView listaAlunos;

    private ArrayList<Aluno> alunos = new ArrayList<>();

    private AdapterAluno adaptador;

    private EscutadorLista el = new EscutadorLista();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInserir = findViewById(R.id.btnInserir);
        listaAlunos = findViewById(R.id.listaAlunos);

        btnInserir.setOnClickListener(new Escutador());

        adaptador = new AdapterAluno(this, alunos);
        listaAlunos.setAdapter(adaptador);

        listaAlunos.setOnItemClickListener(el);
        listaAlunos.setLongClickable(true);
        listaAlunos.setOnItemLongClickListener(el);
    }

    private class Escutador implements View.OnClickListener{
        @Override
        public void onClick(View view){
            Intent i = new Intent(getApplicationContext(), Cadastro.class);
            i.putStringArrayListExtra("alunos", alunos);

            startActivityForResult(i, 1);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i){
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                adaptador.notifyDataSetChanged();
            }
        }
    }

    private class EscutadorLista implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
            Aluno a = alunos.get(i);
            String msg = "";
            msg = msg + "Nome: " + a.getNome() + "/n";
            msg = msg + "Nota 1: " + a.getNota1() + "/n";
            msg = msg + "Nota 2: " + a.getNota2() + "/n";
            msg = msg + "Média: " + a.getMedio();

            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            alunos.remove(i);
            adaptador.notifyDataSetChanged();

            return true;
        }
    }
}