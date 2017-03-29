package dev.hrabowskie.listviewsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView lstSearch;
    private EditText edtSearch;
    private ArrayAdapter<String> adapter;

    String data[]={
            "Harry","Ron", "Hermione","Dumbledore","Moddy",
            "Voldemort", "Draco Malfoy", "Snape","Hagrid",
            "Sirius Black","Dobby","Lupin"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstSearch = (ListView)findViewById(R.id.lstSearch);
        edtSearch = (EditText)findViewById(R.id.edtSearch);
        adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.textView,data);
        lstSearch.setAdapter(adapter);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
