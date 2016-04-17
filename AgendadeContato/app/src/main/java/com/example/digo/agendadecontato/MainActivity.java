package com.example.digo.agendadecontato;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.*;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

import com.example.digo.agendadecontato.database.DataBase;
import com.example.digo.agendadecontato.dominios.entidades.RepositorioContato;
import com.example.digo.agendadecontato.dominios.entidades.entidades.Contatos;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText edtPesquisar;
    private ImageButton btnAdd;
    private ListView lstContatos;

    private DataBase dataBase;
    private SQLiteDatabase conn;
    private RepositorioContato repositorioContato;
    private ArrayAdapter<Contatos> adpContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        edtPesquisar = (EditText)findViewById(R.id.edtTelefone);
        lstContatos = (ListView)findViewById(R.id.lstContatos);

        try {
            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioContato = new RepositorioContato(conn);
            repositorioContato.testeInserir();

            adpContatos = repositorioContato.inserirContato(this);

            lstContatos.setAdapter(adpContatos);

        }catch (SQLException ex){
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setMessage("ERro na conexao "+ex.getMessage());
            dialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        Intent it = new Intent(this, ActCadContato.class);
        startActivityForResult(it, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        adpContatos = repositorioContato.inserirContato(this);

        lstContatos.setAdapter(adpContatos);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Contatos contato = adpContatos.getItem(position);
        Intent it = new Intent(this, ActCadContato.class);
        it.putExtra("CONTATO", contato);
        startActivityForResult(it, 0);
    }
}
