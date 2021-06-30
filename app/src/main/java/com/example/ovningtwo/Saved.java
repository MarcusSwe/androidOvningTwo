package com.example.ovningtwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;


import android.widget.TextView;
import android.widget.Toast;



public class Saved extends AppCompatActivity {

    private UserInfo recieveUser;
    private ItemViewModelString omegaString;

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
        forName.setText(recieveUser.getForName());
        surName.setText(recieveUser.getSurName());
        age.setText(String.valueOf(recieveUser.getAge()));
        occupation.setText(recieveUser.getOccupation());
        hobbies.setText(recieveUser.getHobbies());

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

    @Override
    public void onBackPressed() {
        recieveUser.setForName((String) forName.getText());
        recieveUser.setSurName((String) surName.getText());

        recieveUser.setAge(Integer.parseInt((String) age.getText()));

        recieveUser.setOccupation((String) occupation.getText());
        recieveUser.setHobbies((String) hobbies.getText());
        startActivity(new Intent(this, MainActivity.class).putExtra("inlog",recieveUser));
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


    public void onClickSave(View view) {
        Toast.makeText(this, "Saved!",Toast.LENGTH_LONG).show();
        Intent iblandUndrarMan  = new Intent(this, MainActivity.class);
        iblandUndrarMan.putExtra("inlog", recieveUser);
        iblandUndrarMan.putExtra("saved", "saved");
        startActivity(iblandUndrarMan);
    }


}