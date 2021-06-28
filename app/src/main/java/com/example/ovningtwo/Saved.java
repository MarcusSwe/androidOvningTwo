package com.example.ovningtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

public class Saved extends AppCompatActivity {


    private Button save;
    private View omega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        save = findViewById(R.id.buttonSave);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true; // om nenyn finns returer true
    }



    public boolean onOptionsItemSelected (MenuItem item){


        switch (item.getItemId()){
            case R.id.menuMain:
                Log.d("menuMain", "menu main selected");

                startActivity(new Intent(Saved.this, MainActivity.class));

                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu form selected");

                startActivity(new Intent(Saved.this, Formular.class));

                return true;
            case R.id.menuShowInfo:
                Log.d("showInfo","show menu selected");




                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClickSave(View view) {

    }
}