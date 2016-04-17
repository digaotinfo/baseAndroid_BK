package com.example.digao.base.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.example.digao.base.Model.Categoria;
import com.example.digao.base.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by digao on 16/04/16.
 */
public class CategoriaAdapter extends ArrayAdapter<Categoria> {
    private Context context;
    private ArrayList<Categoria> categoriaList;

    public CategoriaAdapter(Context context, ArrayList<Categoria> categoriaList){
        super(context, 0 , (List<Categoria>) categoriaList);

        this.context = context;
        this.categoriaList = categoriaList;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Categoria categoriPosicao = this.categoriaList.get(position);

        convertView = LayoutInflater.from(this.context).inflate(R.layout.list_categoria, null);

        TextView categoria = (TextView)convertView.findViewById(R.id.categoria);
        categoria.setText(categoriPosicao.getCategoria_ptbr());

        Log.d("###", ">>>>>>>>>>>>>>>>>>>>>>>>"+categoriPosicao);
        ImageView imagem = (ImageView)convertView.findViewById(R.id.img);
        if( categoriPosicao.getBotao_ptbr().toString() != "" ) {
            Picasso.with(context)
                    .load(categoriPosicao.getBotao_ptbr())
                    .into(imagem);
        }


        convertView.setTag(categoriaList.get(position).getId());

        return convertView;
    }
}
