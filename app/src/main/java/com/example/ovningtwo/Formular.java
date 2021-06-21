package com.example.ovningtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Formular extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);
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
                Toast.makeText(this, "Login",Toast.LENGTH_LONG).show();
                startActivity(new Intent(Formular.this, MainActivity.class));

                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu form selected");
                Toast.makeText(this, "Form",Toast.LENGTH_LONG).show();


                return true;
            case R.id.menuShowInfo:
                Log.d("showInfo","show menu selected");
                Toast.makeText(this, "Info",Toast.LENGTH_LONG).show();
                startActivity(new Intent (Formular.this, Saved.class));


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}