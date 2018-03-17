package com.example.bangijan69.robbydwih_1202150024_modul4;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editText_sycn;
    Button button_async;
    TextView textView;
    ProgressDialog prpgresbar;

    ListView listView;
    ArrayAdapter adapter;


    String[]  data_mahasisswa={"budi","anu","ini","itu"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_async = (Button) findViewById(R.id.button_async); // parsing  button
        listView =(ListView)findViewById(R.id.list_item); // parsing
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,new ArrayList<String>()); // set array adapter



        button_async.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listView.setAdapter(adapter); // set list adapeter
                new back().execute(); // mejalankan class asycntask


            }
        });
    }


    class back extends AsyncTask<Void, String, String> {
        int count=0;
        ArrayAdapter<String> adapter;
        @Override
        protected void onPreExecute() {
          adapter = (ArrayAdapter<String>)listView.getAdapter();
            prpgresbar = new ProgressDialog(MainActivity.this);
            prpgresbar.setMessage("LOading"); // judul
            prpgresbar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);  // bentuk progress bar
            prpgresbar.setIndeterminate(true);
            prpgresbar.setProgress(0);
            prpgresbar.setCancelable(true); // ada tombol cancle
            prpgresbar.setMax(4); // set maxsimum
            prpgresbar.show(); // progress dialog tampil
        }

        @Override
        protected String doInBackground(Void... voids) {
            for(String nama:data_mahasisswa){
                publishProgress(nama);

                try {
                    Thread.sleep(1000); // sleep 1 deitk
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "data sudah ditambahakan";
        }

        @Override
        protected void onProgressUpdate(String... values) {
         adapter.add(values[0]); // add nama di ada[tor
         count++;
         Log.d("count ini ","dawed "+ count);
        prpgresbar.setProgress(count);
        }

        @Override
        protected void onPostExecute(String result) {
            prpgresbar.dismiss(); // progress bar sembunyi
            Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

        }
    }

}

