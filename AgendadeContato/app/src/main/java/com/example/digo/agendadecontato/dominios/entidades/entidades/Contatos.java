package com.example.digo.agendadecontato.dominios.entidades.entidades;

import android.content.Context;

import java.io.Serializable;

/**
 * Created by Digão on 10/10/15.
 */
public class Contatos implements Serializable {
    private long _id;
    private String nome;
    private String telefone;
    private String tipotelefone;
    private String datasespeciais;
    private String tipodatasespeciais;

    public Contatos(){

    }

    @Override
    public String toString() {
        return nome+" - "+telefone;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTipotelefone() {
        return tipotelefone;
    }

    public void setTipotelefone(String tipotelefone) {
        this.tipotelefone = tipotelefone;
    }

    public String getDatasespeciais() {
        return datasespeciais;
    }

    public void setDatasespeciais(String datasespeciais) {
        this.datasespeciais = datasespeciais;
    }

    public String getTipodatasespeciais() {
        return tipodatasespeciais;
    }

    public void setTipodatasespeciais(String tipodatasespeciais) {
        this.tipodatasespeciais = tipodatasespeciais;
    }


}
