package com.example.ovningtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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
import android.widget.TextView;
import android.widget.Toast;

public class Saved extends AppCompatActivity {

    private UserInfo recieveUser;
    private ItemViewModelString omegaString;

    private Button save;
    private View omega;

    private TextView forName;
    private TextView surName;
    private TextView age;
    private TextView occupation;
    private TextView hobbies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);

        forName = findViewById(R.id.textView120);
        surName = findViewById(R.id.textView121);
        age = findViewById(R.id.textView122);
        occupation = findViewById(R.id.textView123);
        hobbies = findViewById(R.id.textView124);


        recieveUser = getIntent().getParcelableExtra("inlog");

        omegaString = new ViewModelProvider(this).get(ItemViewModelString.class);

        omegaString.selectItem(recieveUser.getUserName());

        forName.setText(recieveUser.getForName());
        surName.setText(recieveUser.getSurName());
        age.setText(String.valueOf(recieveUser.getAge()));
        occupation.setText(recieveUser.getOccupation());
        hobbies.setText(recieveUser.getHobbies());

        save = findViewById(R.id.buttonSave);



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



    public boolean onOptionsItemSelected (MenuItem item){


        switch (item.getItemId()){
            case R.id.menuMain:
                Log.d("menuMain", "menu main selected");

                startActivity(new Intent(Saved.this, MainActivity.class).putExtra("inlog",recieveUser));

                return true;
            case R.id.menuFormular:
                Log.d("formular", "menu form selected");

                startActivity(new Intent(Saved.this, Formular.class).putExtra("inlog",recieveUser));

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

    @Override
    public void onBackPressed() {

        recieveUser.setForName((String) forName.getText());
        recieveUser.setSurName((String) surName.getText());


            recieveUser.setAge(Integer.parseInt((String) age.getText()));


        recieveUser.setOccupation((String) occupation.getText());
        recieveUser.setHobbies((String) hobbies.getText());
        startActivity(new Intent(this, MainActivity.class).putExtra("inlog",recieveUser));

    }

}