package sg.edu.rp.c346.id20039202.c346saassignment;

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
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {
    EditText etEnter, etEnterIndex;
    Button btnAdd, btnUpdate, btnDelete;
    ListView lvProducts;
    ArrayList<String> alProducts;   //declare arrayList
    ArrayAdapter<String> aaProducts;   //declare arrayAdapter
    Spinner spnProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        etEnter = findViewById(R.id.editText1);
        etEnterIndex = findViewById(R.id.editText2);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnDelete = findViewById(R.id.buttonDelete);
        lvProducts = findViewById(R.id.listViewProducts);
        spnProducts = findViewById(R.id.spinner);

        alProducts = new ArrayList<>();   //create arrayList of products
        alProducts.add("Expires 2022-2-1 Fire HD Tablet");
        alProducts.add("Expires 2022-3-1 Mac Book Air Charger");
        alProducts.add("Expires 2021-9-4 Adult Layer Mask");
        alProducts.add("Expires 2022-8-3 AA Batteries");
        alProducts.add("Expires 2021-8-8 Starbucks K-Cup Coffee");

        aaProducts = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, alProducts);   // link aaProducts to alProducts
        lvProducts.setAdapter(aaProducts);   //link lvProducts to aaProducts

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newProduct = etEnter.getText().toString();  //Enter new product
                int pos = Integer.parseInt(etEnterIndex.getText().toString());  //Enter position number
                alProducts.add(pos, newProduct); //add new product & position
                aaProducts.notifyDataSetChanged();  //notify arrayAdapter for update
                etEnter.setText(""); //set text to nothing to get ready for another entry
                Collections.sort(alProducts);   //sort alphabetically
                Collections.reverse(alProducts);
            }
        });

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ItemListActivity.this,   //Display product toast
                        alProducts.get(position), Toast.LENGTH_LONG).show();
                etEnterIndex.setText(""+position);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String deleteProduct = etEnter.getText().toString();
                int pos = Integer.parseInt(etEnterIndex.getText().toString());
                alProducts.remove(pos);
                alProducts.remove(deleteProduct);
                aaProducts.notifyDataSetChanged();
                etEnter.setText("");
                etEnterIndex.setText("");

            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateProduct = etEnter.getText().toString();
                int pos = Integer.parseInt(etEnterIndex.getText().toString());
                alProducts.set(pos, updateProduct);
                aaProducts.notifyDataSetChanged();
                etEnter.setText("");
                etEnterIndex.setText("");


            }
        });

        spnProducts.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                etEnter.setText("Spinner Products" + spnProducts.getSelectedItem() + "select");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}