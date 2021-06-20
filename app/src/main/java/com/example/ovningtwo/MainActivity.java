package com.example.ovningtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.KeyEventDispatcher;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private InputMethodManager im;
    private TextView textviewUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewUsername = findViewById(R.id.textView14);
        im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


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
                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu formulär selected");
                Toast.makeText(this, "Formulär",Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuShowInfo:
                Log.d("showInfo","show menu selected");
                Toast.makeText(this, "Info",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onClickUsername(View view) {
        Log.d("CPÅKE", "test test");



        im.showSoftInput(view, InputMethodManager.SHOW_FORCED);


    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){

        String fromUsername = textviewUsername.getText().toString();
        
      if(fromUsername.equals("click to edit")) {
          textviewUsername.setText("");
          fromUsername = "";
          Log.d("KOLLA", fromUsername);
      }

        char x = (char) event.getUnicodeChar();
        textviewUsername.setText(fromUsername + String.valueOf(x));


        return super.onKeyUp(keyCode, event);
    }


}