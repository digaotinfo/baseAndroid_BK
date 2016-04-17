package com.example.digao.base.Adapter;

import android.content.Context;
import android.view.*;
import android.widget.*;

import com.example.digao.base.Model.Conteudo;
import com.example.digao.base.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digao on 17/04/16.
 */
public class ConteudoAdapter extends ArrayAdapter<Conteudo> {
    private Context context;
    private ArrayList<Conteudo> conteudoArrayList;

    public ConteudoAdapter(Context context, ArrayList<Conteudo> conteudoList){
        super(context, 0 , (List<Conteudo>) conteudoList);

        this.context = context;
        this.conteudoArrayList = conteudoList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Conteudo conteudoPosicao = this.conteudoArrayList.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.conteudo_list, null);

        TextView titulo = (TextView)convertView.findViewById(R.id.titulo);
        titulo.setText(conteudoPosicao.getTitulo_ptbr());


        convertView.setTag(conteudoArrayList.get(position).getId());

        return convertView;
    }
}
