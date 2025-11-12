package com.example.gettingstartedapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etUsername,etPassword;
    Button btnRegister, btnLogin, btnShowAll;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Initialize All
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        btnShowAll= findViewById(R.id.btnShowAll);
        tvResult = findViewById(R.id.tvResult);

    }

    public void onClick(View view) {
        String Strusername = etUsername.getText().toString();
        String Strpassword = etPassword.getText().toString();

        if(view.getId() == R.id.btnRegister){
            Toast.makeText(this, Strusername, Toast.LENGTH_LONG).show();

            DatabaseHelper dbHelper = new DatabaseHelper(this);
            UserDao userDao = new UserDao(dbHelper);
            User user = new User();

            user.username = Strusername;
            user.password = Strpassword;
            userDao.addUser(user);
        }

        else if(view.getId() == R.id.btnLogin){
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            UserDao userDao = new UserDao(dbHelper);

            User user= userDao.checkUser(Strusername, Strpassword);

            if(user.username!=null){
                Toast.makeText(this, user.username+" password: "+ user.password, Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"no such user", Toast.LENGTH_LONG).show();
            }
        }

        else if(view.getId()== R.id.btnShowAll){
            DatabaseHelper db = new DatabaseHelper(this);
            UserDao userDao = new UserDao(db);

            ArrayList<User> users = userDao.getAllUsers();
            String result = "";
            for(int i = 0; i<users.size(); i++){
                result+= users.get(i).username+"\n";
            }
            tvResult.setText(result);
        }
    }
}