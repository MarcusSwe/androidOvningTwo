package com.example.ovningtwo;

import androidx.annotation.NonNull;
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
        Log.d("CPCP444444444444", recieveUser.getSurName());
        omegaString.selectItem(recieveUser.getUserName());
        Log.d("CPCP11111111111", String.valueOf(recieveUser.getArrayNumber()));
        Log.d("CPCP11111111111", String.valueOf(recieveUser.getAge()));
        forName.setText(recieveUser.getForName());
        surName.setText(recieveUser.getSurName());
        age.setText(String.valueOf(recieveUser.getAge()));
        occupation.setText(recieveUser.getOccupation());
        hobbies.setText(recieveUser.getHobbies());
        //age.setText(recieveUser.getAge());
        //recieveUser = getIntent().getParcelableExtra("inlog");
        //forName.setText(recieveUser.getForName());
    }

    @Override
    protected void onNewIntent(Intent i) {
        super.onNewIntent(i);
        recieveUser = i.getParcelableExtra("inlog");
        omegaString.selectItem(recieveUser.getUserName());

    }

    public boolean kollaNummber(String text) {
        if (text == null) {
            return false;
        }
        return checkAge.matcher(text).matches();
    }

    @Override
    public void onBackPressed() {

        recieveUser.setForName((String) forName.getText());
        recieveUser.setSurName((String) surName.getText());

        if(kollaNummber((String) age.getText())){
            recieveUser.setAge(Integer.parseInt((String) age.getText()));
        }

        recieveUser.setOccupation((String) occupation.getText());
        recieveUser.setHobbies((String) hobbies.getText());
        startActivity(new Intent(this, MainActivity.class).putExtra("inlog",recieveUser));

    }


    public boolean onOptionsItemSelected (MenuItem item){


        switch (item.getItemId()){
            case R.id.menuMain:
                Log.d("menuMain", "menu main selected");
                recieveUser.setForName((String) forName.getText());
                recieveUser.setSurName((String) surName.getText());
                if(kollaNummber((String) age.getText())){
                    recieveUser.setAge(Integer.parseInt((String) age.getText()));
                }
                recieveUser.setOccupation((String) occupation.getText());
                recieveUser.setHobbies((String) hobbies.getText());
                Log.d("CPCP200", String.valueOf(recieveUser.getArrayNumber()));
                startActivity(new Intent(Formular.this, MainActivity.class).putExtra("inlog",recieveUser));

                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu form selected");


                return true;
            case R.id.menuShowInfo:
                Log.d("showInfo","show menu selected");
                recieveUser.setForName((String) forName.getText());
                recieveUser.setSurName((String) surName.getText());
                if(kollaNummber((String) age.getText())){
                    recieveUser.setAge(Integer.parseInt((String) age.getText()));
                }
                recieveUser.setOccupation((String) occupation.getText());
                recieveUser.setHobbies((String) hobbies.getText());
                startActivity(new Intent (Formular.this, Saved.class).putExtra("inlog",recieveUser));


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
        omega = view;
        anim.cancel();
        anim2.cancel();
        anim4.cancel();
        anim5.cancel();

        omega.startAnimation(anim3);

        String fromUsername = age.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            age.setText("");
        }
        whatEver = 3;

        im2.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();
    }

    public void onClickOccupation(View view) {
        omega = view;
        anim.cancel();
        anim2.cancel();
        anim3.cancel();
        anim5.cancel();

        omega.startAnimation(anim4);

        String fromUsername = occupation.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            occupation.setText("");
        }
        whatEver = 4;

        im2.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();
    }

    public void onClickHobbies(View view) {
        omega = view;
        anim.cancel();
        anim2.cancel();
        anim4.cancel();
        anim3.cancel();

        omega.startAnimation(anim5);

        String fromUsername = hobbies.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            hobbies.setText("");
        }
        whatEver = 5;

        im2.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {


        switch (whatEver) {
            case 1:
                String fromUsername = forName.getText().toString();
                if (fromUsername.equals("doubleclick to edit")) {
                    forName.setText("");
                    fromUsername = "";
                }
                switch (keyCode) {
                    case 67:
                        if (fromUsername.length() > 0) {
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
                        anim3.cancel();
                        anim4.cancel();
                        anim5.cancel();
                        dummy.requestFocus();
                        return true;
                    default:
                        char x = (char) event.getUnicodeChar();
                        forName.setText(fromUsername + String.valueOf(x));
                        dummy.requestFocus();
                        return super.onKeyUp(keyCode, event);
                }
            case 2:
                String fromPassword = surName.getText().toString();
                if (fromPassword.equals("doubleclick to edit")) {
                    surName.setText("");
                    fromPassword = "";
                }
                switch (keyCode) {
                    case 67:
                        if (fromPassword.length() > 0) {
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
                        anim3.cancel();
                        anim4.cancel();
                        anim5.cancel();
                        dummy.requestFocus();
                        return true;
                    default:
                        char x = (char) event.getUnicodeChar();
                        surName.setText(fromPassword + String.valueOf(x));
                        dummy.requestFocus();
                        return super.onKeyUp(keyCode, event);
                }
            case 3:
                String fromAge = age.getText().toString();
                if (fromAge.equals("doubleclick to edit")) {
                    age.setText("");
                    fromAge = "";
                }
                switch (keyCode) {
                    case 67:
                        if (fromAge.length() > 0) {
                            fromAge = fromAge.substring(0, fromAge.length() - 1);
                                age.setText(fromAge);
                        }
                        age.clearFocus();
                        dummy.requestFocus();
                        return true;
                    case 66:
                        Log.d("CPÅKE", "test test");
                        ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                        anim.cancel();
                        anim2.cancel();
                        anim3.cancel();
                        anim4.cancel();
                        anim5.cancel();
                        dummy.requestFocus();
                        return true;
                    default:
                        char x = (char) event.getUnicodeChar();
                        age.setText(fromAge + String.valueOf(x));
                        dummy.requestFocus();
                        return super.onKeyUp(keyCode, event);
                }
            case 4:
                String fromOccupation = occupation.getText().toString();
                if (fromOccupation.equals("doubleclick to edit")) {
                    occupation.setText("");
                    fromOccupation = "";
                }
                switch (keyCode) {
                    case 67:
                        if (fromOccupation.length() > 0) {
                            fromOccupation = fromOccupation.substring(0, fromOccupation.length() - 1);
                            occupation.setText(fromOccupation);
                        }
                        occupation.clearFocus();
                        dummy.requestFocus();
                        return true;
                    case 66:
                        Log.d("CPÅKE", "test test");
                        ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                        anim.cancel();
                        anim2.cancel();
                        anim3.cancel();
                        anim4.cancel();
                        anim5.cancel();
                        dummy.requestFocus();
                        return true;
                    default:
                        char x = (char) event.getUnicodeChar();
                        occupation.setText(fromOccupation + String.valueOf(x));
                        dummy.requestFocus();
                        return super.onKeyUp(keyCode, event);
                }
            case 5:
                String fromHobbies = hobbies.getText().toString();
                if (fromHobbies.equals("doubleclick to edit")) {
                    hobbies.setText("");
                    fromHobbies = "";
                }
                switch (keyCode) {
                    case 67:
                        if (fromHobbies.length() > 0) {
                            fromHobbies = fromHobbies.substring(0, fromHobbies.length() - 1);
                            hobbies.setText(fromHobbies);
                        }
                        hobbies.clearFocus();
                        dummy.requestFocus();
                        return true;
                    case 66:
                        Log.d("CPÅKE", "test test");
                        ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                        anim.cancel();
                        anim2.cancel();
                        anim3.cancel();
                        anim4.cancel();
                        anim5.cancel();
                        dummy.requestFocus();
                        return true;
                    default:
                        char x = (char) event.getUnicodeChar();
                        hobbies.setText(fromHobbies + String.valueOf(x));
                        dummy.requestFocus();
                        return super.onKeyUp(keyCode, event);
                }
        }
        return super.onKeyUp(keyCode, event);
    }


    public void onClickImageViewF(View view) {
        anim.cancel();
        anim2.cancel();
        anim3.cancel();
        anim4.cancel();
        anim5.cancel();
        ((InputMethodManager) Formular.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
    }


    public void formButton(View view) {
        recieveUser.setForName((String) forName.getText());
        recieveUser.setSurName((String) surName.getText());
        if(kollaNummber((String) age.getText())){
            recieveUser.setAge(Integer.parseInt((String) age.getText()));
        }
        recieveUser.setOccupation((String) occupation.getText());
        recieveUser.setHobbies((String) hobbies.getText());
        startActivity(new Intent (Formular.this, Saved.class).putExtra("inlog",recieveUser));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("recieveUser", recieveUser);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        recieveUser = savedInstanceState.getParcelable("recieveUser");
    }

}