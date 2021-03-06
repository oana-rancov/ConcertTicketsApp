package com.example.concerttickets.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.concerttickets.R;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getSimpleName();
    private EditText email, password, name;
    private Button register;
    private static final String USER_LOCAL_STORE = "user_local_store"; //key -> numele fis xml
    private static final String USER_NAME = "user_name"; //key
    private static final String USER_EMAIL = "user_email"; //key

    private String userEmail;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.registerUserID);
        password = findViewById(R.id.registerPassword);
        name = findViewById(R.id.registerName);
        register = findViewById(R.id.btRegister);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity= new UserEntity();
                userEntity.setUserID(email.getText().toString());
                userEntity.setPassword(password.getText().toString());
                userEntity.setName(name.getText().toString());
                Log.d(TAG, "Id = " + email.getText() + "\nPass = " + password.getText() + "\nName = " + name.getText());


                if(validateInput(userEntity)){
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    UserDao userDao = userDatabase.userDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            userDao.registerUser(userEntity);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "User Registered", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();

                }else{
                    Toast.makeText(getApplicationContext(), "Fill all fields!", Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userName = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                userEmail = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    //check fields to be filled
    private Boolean validateInput(UserEntity userEntity){
        if (userEntity.getName().isEmpty() ||
            userEntity.getPassword().isEmpty() ||
            userEntity.getName().isEmpty() ){

            return false;
        }
        return  true;
    }

    @Override
    protected void onPause() {
        saveUserNameInSharedPref();

        saveUserEmailInSharedPref();

        super.onPause();
    }

    //saving user name from register
    private void saveUserNameInSharedPref(){
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_NAME, userName);
        editor.apply();
    }

    //saving user email from register
    private void saveUserEmailInSharedPref() {
        SharedPreferences sharedPreferences = this.getSharedPreferences(USER_LOCAL_STORE, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USER_EMAIL, userEmail);
        editor.apply();
    }


}