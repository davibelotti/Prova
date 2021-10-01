package com.example.prova;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAluno extends ArrayAdapter<Aluno> {
    private Context context;
    private ArrayList<Aluno> alunos;

    public AdapterAluno(Context context, ArrayList<Aluno> alunos){
        super(context, R.layout.item_lista, alunos);
        this.context = context;
        this.alunos = alunos;
    }

    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        View itemView = li.inflate(R.layout.item_lista, parent, false);

        TextView txtNome = itemView.findViewById(R.id.txtNome);
        TextView txtNota1 = itemView.findViewById(R.id.txtNota1);
        TextView txtNota2 = itemView.findViewById(R.id.txtNota2);
        TextView txtMedia = itemView.findViewById(R.id.txtMedia);

        txtNome.setText(alunos.get(position).getNome());
        txtNota1.setText((int) alunos.get(position).getNota1());
        txtNota2.setText((int) alunos.get(position).getNota2());
        txtMedia.setText((int) alunos.get(position).getMedio());

        return itemView;
    }
}
