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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    private InputMethodManager im;
    private TextView textviewUsername;
    private View omega;
    private Button dummy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummy = findViewById(R.id.dummyMain);

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
                Log.d("formular", "menu form selected");
                Toast.makeText(this, "Form",Toast.LENGTH_LONG).show();
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

        omega = view;


        im.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){



        String fromUsername = textviewUsername.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            textviewUsername.setText("");
            fromUsername = "";
        }


        Log.d("CPÅKE", String.valueOf(keyCode));


        switch (keyCode) {
            case 67:
                if(fromUsername.length() >0){
                    fromUsername = fromUsername.substring(0, fromUsername.length() - 1);
                    textviewUsername.setText(fromUsername);
                }
                return true;
            case 45:
                Log.d("CPÅKE", "test test");
                ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                return true;
            default:
                char x = (char) event.getUnicodeChar();
                textviewUsername.setText(fromUsername + String.valueOf(x));
                return super.onKeyUp(keyCode, event);
        }

    }



}