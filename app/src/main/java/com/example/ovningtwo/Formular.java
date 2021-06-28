package com.example.ovningtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Formular extends AppCompatActivity {


   private UserInfo recieveUser;
   private ItemViewModelString omegaString;

   private InputMethodManager im2;
   private View omega;
   private int whatEver;
   private Button dummy;
   private Animation anim;
   private Animation anim2;
    private Animation anim3;
    private Animation anim4;
    private Animation anim5;

   private TextView forName;
    private TextView surName;
    private TextView age;
    private TextView occupation;
    private TextView hobbies;

    private Pattern checkAge = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formular);

         forName = findViewById(R.id.textView12);
         surName = findViewById(R.id.textView18);
         age = findViewById(R.id.textView20);
         occupation = findViewById(R.id.textView22);
         hobbies = findViewById(R.id.textView24);

        dummy = findViewById(R.id.dummyMainF);
        omega = findViewById(R.id.imageViewF);

        recieveUser = getIntent().getParcelableExtra("inlog");

        omegaString = new ViewModelProvider(this).get(ItemViewModelString.class);

        omegaString.selectItem(recieveUser.getUserName());

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(750);
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(Animation.INFINITE);

        anim2 = new AlphaAnimation(0.0f, 1.0f);
        anim2.setDuration(750);
        anim2.setStartOffset(20);
        anim2.setRepeatMode(Animation.REVERSE);
        anim2.setRepeatCount(Animation.INFINITE);

        anim3 = new AlphaAnimation(0.0f, 1.0f);
        anim3.setDuration(750);
        anim3.setStartOffset(20);
        anim3.setRepeatMode(Animation.REVERSE);
        anim3.setRepeatCount(Animation.INFINITE);

        anim4 = new AlphaAnimation(0.0f, 1.0f);
        anim4.setDuration(750);
        anim4.setStartOffset(20);
        anim4.setRepeatMode(Animation.REVERSE);
        anim4.setRepeatCount(Animation.INFINITE);

        anim5 = new AlphaAnimation(0.0f, 1.0f);
        anim5.setDuration(750);
        anim5.setStartOffset(20);
        anim5.setRepeatMode(Animation.REVERSE);
        anim5.setRepeatCount(Animation.INFINITE);

        im2 = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);

        return true; // om nenyn finns returer true
    }

    @Override
    public void onResume() {
        super.onResume();
        recieveUser = getIntent().getParcelableExtra("inlog");
        omegaString.selectItem(recieveUser.getUserName());
        Log.d("CPCP200", String.valueOf(recieveUser.getArrayNumber()));
        Log.d("CPCP200", String.valueOf(recieveUser.getUserName()));
        forName.setText(recieveUser.getForName());
        //recieveUser = getIntent().getParcelableExtra("inlog");
        //forName.setText(recieveUser.getForName());
    }

    @Override
    protected void onNewIntent(Intent i) {
        super.onNewIntent(i);
        recieveUser = i.getParcelableExtra("inlog");
        omegaString.selectItem(recieveUser.getUserName());
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return checkAge.matcher(strNum).matches();
    }

    @Override
    public void onBackPressed() {

        recieveUser.setForName((String) forName.getText());
        recieveUser.setSurName((String) surName.getText());

        if(isNumeric((String) age.getText())){
            recieveUser.setAge(Integer.parseInt((String) age.getText()));
        }

        recieveUser.setOccupation((String) occupation.getText());
        recieveUser.setHobbies((String) hobbies.getText());
        startActivity(new Intent(this, MainActivity.class).putExtra("CP",recieveUser));

    }


    public boolean onOptionsItemSelected (MenuItem item){


        switch (item.getItemId()){
            case R.id.menuMain:
                Log.d("menuMain", "menu main selected");
                recieveUser.setForName((String) forName.getText());
                recieveUser.setSurName((String) surName.getText());
                if(isNumeric((String) age.getText())){
                    recieveUser.setAge(Integer.parseInt((String) age.getText()));
                }
                recieveUser.setOccupation((String) occupation.getText());
                recieveUser.setHobbies((String) hobbies.getText());
                Log.d("CPCP200", String.valueOf(recieveUser.getArrayNumber()));
                startActivity(new Intent(Formular.this, MainActivity.class).putExtra("CP",recieveUser));

                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu form selected");


                return true;
            case R.id.menuShowInfo:
                Log.d("showInfo","show menu selected");

                startActivity(new Intent (Formular.this, Saved.class));


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void onClickForname(View view) {
        omega = view;

        anim2.cancel();
        anim3.cancel();
        anim4.cancel();
        anim5.cancel();

        omega.startAnimation(anim);

        String fromUsername = forName.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            forName.setText("");
        }
        whatEver = 1;

        im2.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();
    }

    public void onClickSurname(View view) {
        omega = view;
        anim.cancel();
        anim3.cancel();
        anim4.cancel();
        anim5.cancel();

        omega.startAnimation(anim2);

        String fromUsername = surName.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            surName.setText("");
        }
        whatEver = 2;

        im2.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();
    }

    public void onClickAge(View view) {

    }

    public void onClickOccupation(View view) {

    }

    public void onClickHobbies(View view) {

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event){


        if(whatEver ==1){
            String fromUsername = forName.getText().toString();

            if(fromUsername.equals("doubleclick to edit")) {
                forName.setText("");
                fromUsername = "";
            }

            switch (keyCode) {
                case 67:
                    if(fromUsername.length() >0){
                        fromUsername = fromUsername.substring(0, fromUsername.length() - 1);
                        forName.setText(fromUsername);
                    }
                    forName.clearFocus();
                    dummy.requestFocus();
                    return true;
                case 66:
                    Log.d("CPÅKE", "test test");
                    ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    anim.cancel();
                    anim2.cancel();
                    dummy.requestFocus();
                    return true;
                default:
                    char x = (char) event.getUnicodeChar();
                    forName.setText(fromUsername + String.valueOf(x));
                    dummy.requestFocus();
                    return super.onKeyUp(keyCode, event);
            }

        } else {
            String fromPassword = surName.getText().toString();

            if(fromPassword.equals("doubleclick to edit")) {
                surName.setText("");
                fromPassword = "";
            }

            switch (keyCode) {
                case 67:
                    if(fromPassword.length() >0){
                        fromPassword = fromPassword.substring(0, fromPassword.length() - 1);
                        surName.setText(fromPassword);
                    }
                    surName.clearFocus();
                    dummy.requestFocus();
                    return true;
                case 66:
                    Log.d("CPÅKE", "test test");
                    ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    anim.cancel();
                    anim2.cancel();
                    dummy.requestFocus();
                    return true;
                default:
                    char x = (char) event.getUnicodeChar();
                    surName.setText(fromPassword + String.valueOf(x));
                    dummy.requestFocus();
                    return super.onKeyUp(keyCode, event);
            }
        }





    }


    public void onClickImageViewF(View view) {
        anim.cancel();
        anim2.cancel();
        anim3.cancel();
        anim4.cancel();
        anim5.cancel();
        ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
    }


}