package com.e.softwaricaassignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity {
    private EditText etItemName, etItemPrice, etItemImageName, etItemDescription;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etItemImageName = findViewById(R.id.etItemImageName);
        etItemDescription = findViewById(R.id.etItemDescription);
        btnAddItem = findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddItems();
            }
        });
    }

    private void AddItems(){
        String itemname="itemname";
        String itemprice="itemprice";
        String itemimage="itemimage";
        String itemdescription= "itemdescription";

        try {
            PrintStream printStream = new PrintStream(openFileOutput("item.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etItemName.getText().toString()+"->"+etItemPrice.getText().toString()+"->"+etItemImageName.getText().toString()+"->"+etItemDescription.getText().toString());
            Toast.makeText(this,"Add to",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddItemActivity.this,DashboardActivity.class);
            startActivity(intent);


        } catch (IOException e) {
            Log.d("Online Clothing App", "Error:"+e.toString());
            e.printStackTrace();
        }
    }

}


