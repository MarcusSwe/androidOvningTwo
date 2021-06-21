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
    private TextView textviewPassword;
    private View omega;
    private Button dummy;
    private int whatEver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummy = findViewById(R.id.dummyMain);

        textviewUsername = findViewById(R.id.textView14);
        textviewPassword = findViewById(R.id.textView16);

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
        whatEver = 1;
        omega = view;

        im.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();

    }

    public void onClickPassword(View view) {
        whatEver = 2;
        omega = view;

        im.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();

    }

    public void onClickImageView(View view) {

        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);

    }

    public void onClickLogin(View view) {

        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);

    }

    public void onClickCreate(View view) {

        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){


        if(whatEver ==1){
            String fromUsername = textviewUsername.getText().toString();

            if(fromUsername.equals("doubleclick to edit")) {
                textviewUsername.setText("");
                fromUsername = "";
            }

            switch (keyCode) {
                case 67:
                    if(fromUsername.length() >0){
                        fromUsername = fromUsername.substring(0, fromUsername.length() - 1);
                        textviewUsername.setText(fromUsername);
                    }
                    dummy.requestFocus();
                    return true;
                case 66:
                    Log.d("CPÅKE", "test test");
                    ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    dummy.requestFocus();
                    return true;
                default:
                    char x = (char) event.getUnicodeChar();
                    textviewUsername.setText(fromUsername + String.valueOf(x));
                    dummy.requestFocus();
                    return super.onKeyUp(keyCode, event);
            }

        } else {
            String fromPassword = textviewPassword.getText().toString();

            if(fromPassword.equals("doubleclick to edit")) {
                textviewPassword.setText("");
                fromPassword = "";
            }

            switch (keyCode) {
                case 67:
                    if(fromPassword.length() >0){
                        fromPassword = fromPassword.substring(0, fromPassword.length() - 1);
                        textviewPassword.setText(fromPassword);
                    }
                    dummy.requestFocus();
                    return true;
                case 66:
                    Log.d("CPÅKE", "test test");
                    ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    dummy.requestFocus();
                    return true;
                default:
                    char x = (char) event.getUnicodeChar();
                    textviewPassword.setText(fromPassword + String.valueOf(x));
                    dummy.requestFocus();
                    return super.onKeyUp(keyCode, event);
            }
        }





    }



}