package edu.ewubd.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button s,l,e;
    EditText user, pass;
    private final String MySharedPref = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         user = findViewById(R.id.user);
         pass = findViewById(R.id.pass);
         s = findViewById(R.id.signup);
         l = findViewById(R.id.login);
         e = findViewById(R.id.exit);

        s.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Signup.class);
                startActivity(i);
            }
        });
        l.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                SharedPreferences c = getSharedPreferences(MySharedPref,MODE_PRIVATE);
                String u = c.getString("Username",null);
                String p = c.getString("Password",null);

                String user_name = user.getText().toString();
                String pass_word = pass.getText().toString();
                if(u != null && user_name != null && u.equalsIgnoreCase(user_name))
                {
                    if(p != null && pass_word != null && p.equalsIgnoreCase(pass_word))
                    {
                        Toast.makeText(MainActivity.this,"Logged In",Toast.LENGTH_LONG).show();
                    }else {

                        Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
                    }
                }
                else {

                    Toast.makeText(MainActivity.this,"Failed",Toast.LENGTH_LONG).show();
                }


            }
        });

        e.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               finish();
            }
        });

    }


}