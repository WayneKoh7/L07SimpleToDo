package sg.edu.rp.c346.id22000210.l07simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewTodo;
    Button btnAdd;
    Button btnClear;
    ListView lvTodo;
    Button btnDelete;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the variables to their respective UI elements
        etNewTodo = findViewById(R.id.editTextTask);
        btnAdd = findViewById(R.id.btnAdd);
        btnClear = findViewById(R.id.btnClear);
        lvTodo = findViewById(R.id.listViewTask);
        btnDelete = findViewById(R.id.btnDelete);
        spinner = findViewById(R.id.spinner);


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


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i) {
                    case 0:
                        // Code for item 1 selected
                        etNewTodo.setHint("Type in a new task here");
                        btnDelete.setEnabled(false);
                        btnAdd.setEnabled(true);
                        break;

                    case 1:
                        // Code for item 2 selected
                        etNewTodo.setHint("Type in the index of the task to be removed");
                        btnDelete.setEnabled(true);
                        btnAdd.setEnabled(false);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numInput = etNewTodo.getText().toString();
                if(!numInput.isEmpty()) {
                    int index = Integer.parseInt(numInput);
                    if (index >= 0 && index < alTodo.size()) {
                        alTodo.remove(index);
                        aaTodo.notifyDataSetChanged();
                        etNewTodo.setHint("");
                    }
                    if (aaTodo.isEmpty()) {
                        Toast.makeText(MainActivity.this, "You don't have any task to remove", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Wrong index number", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}