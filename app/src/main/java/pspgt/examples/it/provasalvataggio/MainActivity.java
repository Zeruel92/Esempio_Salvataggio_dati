package pspgt.examples.it.provasalvataggio;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button button;
    private EditText editText;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        editText=(EditText) findViewById(R.id.editText);
        //Ottengo le preferenze dell'app (la prima stringa è un identificativo,
        // MODE_PRIVATE Indica che i dati salvati sono accessibili solo all'app che li ha creati
        pref=getSharedPreferences("appdiprova", Context.MODE_PRIVATE);
        //tramite getString recupero il valore dell'oggetto salvato
        textView.setText(pref.getString("stringa",null));
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
    public void onClick(View view) {
        String testo=editText.getText().toString();
        //Istanzio l'editor delle preferenze
        SharedPreferences.Editor editor=pref.edit();
        //Inserisco la lista degli oggetti da salvare con una stringa che li identifica
        editor.putString("stringa",testo);
        //Effettuo il salvataggio effettivo
        editor.commit();
    }
}
