package com.example.concerttickets.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.concerttickets.MainScreen;
import com.example.concerttickets.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText email;
    private EditText password;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.loginUsername);
        password = findViewById(R.id.loginPassword);
        loginButton = findViewById(R.id.btLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "EMAIL= " + email.getText() + "\nPASS= " + password.getText());

                String textEmail = email.getText().toString();
                String textPass = password.getText().toString();

                //atentionare cand nu ai completat emailul
                if(textEmail.isEmpty()){
                    email.setError("This field should not be empty!");
                }else{
                    email.setError(null); //ca sa nu mai apara nici semnul rosu
                }

                //atentionare cand nu ai completat parola
                if(textPass.isEmpty()){
                    password.setError("This field should not be empty!");
                }else{
                    password.setError(null); //ca sa nu mai apara nici semnul rosu
                }

                if(textEmail.isEmpty() || textPass.isEmpty()){
                    Log.d(TAG, "Fields not completed!");
                }
                else{
                    UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
                    final UserDao userDao = userDatabase.userDao();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserEntity userEntity = userDao.login(textEmail, textPass);

                            if(userEntity == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getApplicationContext(), "Invalid Credentials!", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }else {
                                //takes you to the main screen -> navigation drawer
                                Intent intent = new Intent(LoginActivity.this, MainScreen.class);
                                startActivity(intent);
                            }
                        }
                    }).start();


                }
            }
        });

    }



}