package sg.edu.rp.c346.id22000210.l07simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewTodo;
    Button btnAdd;
    Button btnClear;
    ListView lvTodo;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the variables to their respective UI elements
        etNewTodo = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        lvTodo = findViewById(R.id.listViewTask);


        // New ArrayList to store the to-do items
        alTodo = new ArrayList<>();

        // To display the TextView for the ListView
        aaTodo = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTodo);

        //Sets ListView to use the ArrayAdapter sot hat ListView can display the items from ArrayAdapter
        lvTodo.setAdapter(aaTodo);

        // When button is clicked, OnClick method will be executed
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newTodo = etNewTodo.getText().toString();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alTodo.clear();
                aaTodo.notifyDataSetChanged();
            }
        });
    }
}