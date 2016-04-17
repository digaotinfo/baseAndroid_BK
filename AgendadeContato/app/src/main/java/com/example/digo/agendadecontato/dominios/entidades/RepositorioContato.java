package com.example.digo.agendadecontato.dominios.entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.widget.ArrayAdapter;

import com.example.digo.agendadecontato.dominios.entidades.entidades.Contatos;

/**
 * Created by Digão on 10/10/15.
 */
public class RepositorioContato {

    public SQLiteDatabase conn;
    public RepositorioContato(SQLiteDatabase conn){
        this.conn = conn;
    }

    public void testeInserir(){
        /*
        for(int i=0; i<10; i++){
            ContentValues values = new ContentValues();
            values.put("TELEFONE","5555-5555");

            conn.insertOrThrow("CONTATO",null, values);
        }
        */


    }

    public ArrayAdapter<Contatos> inserirContato(Context context){
        ArrayAdapter<Contatos> adpContatos = new ArrayAdapter<Contatos>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("CONTATO", null, null, null, null, null, null);

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do{
                Contatos contato = new Contatos();
                contato.set_id(cursor.getLong(0));
                contato.setNome(cursor.getString(1));
                contato.setTelefone(cursor.getString(2));

                //String telefone = cursor.getString(2);
                adpContatos.add(contato);
            }while (cursor.moveToNext());
        }
        return adpContatos;
    }

    public void inserir(Contatos contato){
        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("TIPOTELEFONE", contato.getTipotelefone());
        values.put("DATASESPECIAIS", contato.getDatasespeciais());
        values.put("TIPODATASESPECIAIS", contato.getTipodatasespeciais());

        conn.insertOrThrow("CONTATO",null, values);
    }
}
