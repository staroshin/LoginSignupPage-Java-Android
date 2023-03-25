package edu.ewubd.loginapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Signup extends AppCompatActivity {
    Button c, b;
    EditText user, pass,c_pass;
    private final String MySharedPref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);


        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        c_pass = findViewById(R.id.c_pass);
        c = findViewById(R.id.create);
        b = findViewById(R.id.back);

        c.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String user_name = user.getText().toString();
                String c_pass_word = c_pass.getText().toString();
                String pass_word = pass.getText().toString();

                if(pass_word != null && c_pass_word != null && pass_word.equalsIgnoreCase(c_pass_word))
                {
                    SharedPreferences c = getSharedPreferences(MySharedPref,MODE_PRIVATE);
                    SharedPreferences.Editor edt = c.edit();
                    edt.putString("Username",user_name);
                    edt.putString("Password",pass_word);

                    edt.commit();

                    Toast.makeText(Signup.this,"Successful",Toast.LENGTH_LONG).show();



                }else {

                    Toast.makeText(Signup.this,"Failed",Toast.LENGTH_LONG).show();
                }
            }
        });

        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}
