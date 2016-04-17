package br.com.apriscoproducoes.revista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    String url = null;
    private WebView revista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "http://issuu.com/rodrigonogueiracosta/docs/apostila_wordpress?e=19683703/31052406";
//        url = "file:///android_asset/issuu.html";
        revista = (WebView)findViewById(R.id.revista);
        revista = (WebView)this.findViewById(R.id.revista);//<<< url externa


        revista.loadUrl(url);
        revista.getSettings().setJavaScriptEnabled(true);//<<< url externa

        //>>> forçar link a ser mostrado no app
        revista.setWebViewClient(new WebViewClient());
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
}
