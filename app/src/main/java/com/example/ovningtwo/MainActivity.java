package com.example.ovningtwo;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.ViewModelProvider;



import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    private UserInfo recieveUser;

    private TextView textviewUsername;
    private TextView textviewPassword;

    private ItemViewModelString omegaString;

    private InputMethodManager im;
    private View omega;
    private int whatEver;
    private Button dummy;
    private Animation anim;
    private Animation anim2;

    private ArrayList<UserInfo> userS;

    private int arrayPlace = 0;
    private UserInfo dummyX = new UserInfo("dummy","dummy",0);


    private String retrieveSaveString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dummy = findViewById(R.id.dummyMain);
        omega = findViewById(R.id.imageView); // fixar crash när man trycker utanför i starten pga variabel är tom vid start'

        userS = new ArrayList<>();



        textviewUsername = findViewById(R.id.textView14);
        textviewPassword = findViewById(R.id.textView16);

        omegaString = new ViewModelProvider(this).get(ItemViewModelString.class);
        //recieveUser = dummyX;

        /*
        final loggedIn fragment = new loggedIn();
        getFragmentManager().beginTransaction().add(R.id.fragmentContainerView, fragment).commit();*/

        /*
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragmentContainerView, fragment)
                .commit();*/

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

        im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        SharedPreferences saVe = this.getPreferences(Context.MODE_PRIVATE);
        retrieveSaveString = saVe.getString("userS",null);
        if(!(retrieveSaveString == null)){
        Type type = new TypeToken<ArrayList<UserInfo>>(){}.getType();
        userS = new Gson().fromJson(retrieveSaveString, type);
        } else userS.add(dummyX);

    }


    @Override
    public void onResume() {
        super.onResume();
        recieveUser = getIntent().getParcelableExtra("inlog"); // kommer denna krasha efter crash????

        omegaString.selectItem(userS.get(arrayPlace).getUserName());

        try {
            arrayPlace = recieveUser.getArrayNumber();
            userS.get(arrayPlace).setForName(recieveUser.getForName());
            userS.get(arrayPlace).setUserName(recieveUser.getUserName());
            userS.get(arrayPlace).setPassword(recieveUser.getPassword());
            omegaString.selectItem(recieveUser.getUserName());
        }
        catch(Exception e) {}

    }


    @Override
    public void onNewIntent(Intent i) {
        super.onNewIntent(i);

       Bundle extras = i.getExtras();

            recieveUser = i.getParcelableExtra("inlog");
            arrayPlace = recieveUser.getArrayNumber();
            userS.get(arrayPlace).setForName(recieveUser.getForName());
            userS.get(arrayPlace).setSurName(recieveUser.getSurName());
            userS.get(arrayPlace).setOccupation(recieveUser.getOccupation());
            userS.get(arrayPlace).setHobbies(recieveUser.getHobbies());
            userS.get(arrayPlace).setUserName(recieveUser.getUserName());
            userS.get(arrayPlace).setPassword(recieveUser.getPassword());
            userS.get(arrayPlace).setAge(recieveUser.getAge());

            omegaString.selectItem(recieveUser.getUserName());

        if(extras.containsKey("saved")){
            saveUsers();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        anim.cancel();
        anim2.cancel();
        return true; // om nenyn finns returer true
    }


    public boolean onOptionsItemSelected (MenuItem item){
        anim.cancel();
        anim2.cancel();

        switch (item.getItemId()){
            case R.id.menuMain:
                anim.cancel();
                anim2.cancel();
                ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                return true;
            case R.id.menuFormular:

                startActivity(new Intent(this, Formular.class).putExtra("inlog",userS.get(arrayPlace)));
                anim.cancel();
                anim2.cancel();
                ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                return true;
            case R.id.menuShowInfo:
                startActivity(new Intent (this, Saved.class).putExtra("inlog",userS.get(arrayPlace)));
                anim.cancel();
                anim2.cancel();
                ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void onClickUsername(View view) {
        omega = view;
        anim2.cancel();
        omega.startAnimation(anim);
        String fromUsername = textviewUsername.getText().toString();

        if(fromUsername.equals("doubleclick to edit")) {
            textviewUsername.setText("");
            fromUsername = "";
        }
        whatEver = 1;
        im.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();

    }

    public void onClickPassword(View view) {
        omega = view;
        anim.cancel();
        omega.startAnimation(anim2);
        String fromPassword = textviewPassword.getText().toString();

        if(fromPassword.equals("doubleclick to edit")) {
            textviewPassword.setText("");
            fromPassword = "";
        }
        whatEver = 2;
        im.showSoftInput(omega, InputMethodManager.SHOW_FORCED);
        dummy.requestFocus();

    }

    public void onClickImageView(View view) {
        anim.cancel();
        anim2.cancel();
     ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);

    }

    public void onClickLogin(View view) {
        anim.cancel();
        anim2.cancel();
        boolean finns = false;
        ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);

        //NEDAN FUNGERAR -- Låt stå
       // loggedIn setUserLoggedIn = (loggedIn) getSupportFragmentManager().getFragments().get(0);
        //setUserLoggedIn.setTextFragment("Logged in as: " + textviewUsername.getText());

        //DETTA FUNGERAR MED --


        // -- låt stå --
        //fragment.setTextFragment("Logged in as: " +textviewUsername.getText());


        for(int i = 0; i < userS.size(); i++) {
            if(userS.get(i).getUserName().equals(textviewUsername.getText()) && userS.get(i).getPassword().equals(textviewPassword.getText()))
            {
                arrayPlace = 0;
                arrayPlace = i;
                omegaString.selectItem((String) textviewUsername.getText());
                finns = true;
            }
        }
        if(!finns){
            Toast.makeText(this, "WRONG PASSWORD!",Toast.LENGTH_LONG).show();
        }

    }

    public void onClickCreate(View view) {

        boolean userExist=false;
         arrayPlace = 0;

        for(int i = 0; i < userS.size(); i++) {

         if(userS.get(i).getUserName().equals(textviewUsername.getText()))
         {userExist=true;
         }
        }

        arrayPlace = userS.size();

        if(!userExist){
        UserInfo user = new UserInfo(((String) textviewUsername.getText()), ((String) textviewPassword.getText()), arrayPlace);
        userS.add(user);
        Toast.makeText(this, "USER CREATED",Toast.LENGTH_LONG).show();
        }
        else {textviewUsername.setText("doubleclick to edit");
            Toast.makeText(this, "USER EXIST!",Toast.LENGTH_LONG).show();
        }

        anim.cancel();
        anim2.cancel();
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
                    textviewUsername.clearFocus();
                    dummy.requestFocus();
                    return true;
                case 66:
                    ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    anim.cancel();
                    anim2.cancel();
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
                    textviewPassword.clearFocus();
                    dummy.requestFocus();
                    return true;
                case 66:
                    ((InputMethodManager) MainActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(omega.getWindowToken(), 0);
                    anim.cancel();
                    anim2.cancel();
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

    public void toForm(View view) {
        startActivity(new Intent(this, Formular.class).putExtra("inlog",userS.get(arrayPlace)));
    }

    public void logout(View view) {
        arrayPlace = 0;
        omegaString.selectItem((userS.get(arrayPlace).getUserName()));
        textviewUsername.setText("doubleclick to edit");

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("userS", userS);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        userS = savedInstanceState.getParcelableArrayList("userS");
    }

    public void saveUsers(){
        SharedPreferences saVe = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = saVe.edit();

        Gson gsonSave = new Gson();
        String recieveUserGson = gsonSave.toJson(userS);

        editor.putString("userS", recieveUserGson);
        editor.apply();

    }


}