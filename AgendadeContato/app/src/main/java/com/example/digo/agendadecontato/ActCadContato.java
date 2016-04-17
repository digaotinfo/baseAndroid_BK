package com.example.digo.agendadecontato;

import android.app.AlertDialog;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.digo.agendadecontato.database.DataBase;
import com.example.digo.agendadecontato.dominios.entidades.RepositorioContato;
import com.example.digo.agendadecontato.dominios.entidades.entidades.Contatos;

import java.util.Date;

public class ActCadContato extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtTelefone;
    private EditText edtDatasEspeciais;

    private Spinner spnTipoTelefone;
    private Spinner spnTipoDatasEspeciais;

    private ArrayAdapter<String> adpTipoTelefone;
    private ArrayAdapter<String> adpTipoDatasEspeciais;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioContato repositorioContato;
    private Contatos contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_cad_contato);

        edtNome             = (EditText)findViewById(R.id.edtNome);
        edtTelefone         = (EditText)findViewById(R.id.edtTelefone);
        edtDatasEspeciais   = (EditText)findViewById(R.id.edtDatasEspeciais);

        spnTipoTelefone         = (Spinner)findViewById(R.id.spnTipoTelefone);
        spnTipoDatasEspeciais   = (Spinner)findViewById(R.id.spnTipoDatasEspeciais);

        adpTipoTelefone         =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adpTipoTelefone.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        adpTipoDatasEspeciais   =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adpTipoDatasEspeciais.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        adpTipoTelefone.add("Principal");
        adpTipoTelefone.add("REsidecia");
        adpTipoTelefone.add("Celular");
        adpTipoTelefone.add("Fax");
        adpTipoTelefone.add("Trabalho");

        adpTipoDatasEspeciais.add("Aniversario");
        adpTipoDatasEspeciais.add("Nascimeto");
        adpTipoDatasEspeciais.add("Outros");

        spnTipoTelefone.setAdapter(adpTipoTelefone);
        spnTipoDatasEspeciais.setAdapter(adpTipoDatasEspeciais);

        Bundle bundle = getIntent().getExtras()
        if( (bundle != null) && (bundle.containsKey("CONTATO")) ){
            contato = (Contatos)bundle.getSerializable("CONTATO");
        }else{
            contato = new Contatos();
        }

        try {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioContato = new RepositorioContato(conn);


        }catch (SQLException ex){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("ERro na conexao "+ex.getMessage());
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_act_cad_contato, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
      switch (item.getItemId()){
          case R.id.mni_salvar:
              if(contato == null){
                  inserir();
              }
              finish();
          break;

          case R.id.mni_excluir:

              break;
      }
        return super.onOptionsItemSelected(item);
    }

    private void inserir(){
        try {
            contato = new Contatos();
            contato.setNome(edtNome.getText().toString());
            contato.setTelefone(edtTelefone.getText().toString());
            Date date = new Date();
            contato.setDatasespeciais(date.toString());

            contato.setTipotelefone("");
            contato.setTipodatasespeciais("");

            repositorioContato.inserir(contato);

        }catch (SQLException ex){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("Erro ao inserir "+ex.getMessage());
            dialog.show();
        }
    }
}
