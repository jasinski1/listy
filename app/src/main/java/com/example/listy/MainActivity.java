package com.example.listy;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String>arraylista = new ArrayList<>();
    ListView listView;
    Button button;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        arraylista.add("warzywo");
        arraylista.add("warzywo");
        arraylista.add("warzywo");
        arraylista.add("warzywo");
        arraylista.add("warzywo");
        listView = findViewById(R.id.lista);
        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextText);
        arrayAdapter = new ArrayAdapter<>(
                MainActivity.this, android.R.layout.simple_list_item_1,
                arraylista
        );
        listView.setAdapter((arrayAdapter));
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String warzywo = editText.getText().toString();
                        arraylista.add(warzywo);
                        arrayAdapter.notifyDataSetChanged();
                        editText.setText("");
                    }
                }
        );
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        TextView textView = (TextView) view;
                        textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                    }
                }
        );
        listView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        arraylista.remove(i);
                        arrayAdapter.notifyDataSetChanged();
                        return false;
                    }
                }
        );


    }
}