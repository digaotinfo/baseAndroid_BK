package com.example.digo.agendadecontato.database;

/**
 * Created by Digão on 09/10/15.
 */
public class ScriptSQL {

    public static String getCreateContato(){
        StringBuilder sqlScript = new StringBuilder();

        sqlScript.append("CREATE TABLE IF NOT EXISTS CONTATO ( ");
        sqlScript.append("_id INTEGER NOT NULL ");
        sqlScript.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlScript.append("NOME VARCHAR (255), ");
        sqlScript.append("TELEFONE VARCHAR (14), ");
        sqlScript.append("TIPOTELEFONE VARCHAR (1), ");
        sqlScript.append("DATASESPECIAIS DATE, ");
        sqlScript.append("TIPODATASESPECIAIS VARCHAR (1)");
        sqlScript.append(");");

        return sqlScript.toString();


    }
}
