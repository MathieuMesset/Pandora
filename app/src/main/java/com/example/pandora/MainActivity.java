package com.example.pandora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Login_user1(View view) {

        Intent intent = new Intent(this, LoginActivity.class);

        Button b1 = (Button) findViewById(R.id.TL_button);

        String username = b1.getText().toString();

        intent.putExtra("USERNAME",username);

        startActivity(intent);

    }

    public void Login_user2(View view) {

        Intent intent = new Intent(this, LoginActivity.class);

        Button b2 = (Button) findViewById(R.id.TR_button);

        String username = b2.getText().toString();

        intent.putExtra("USERNAME", username);

        startActivity(intent);

    }

    public void Login_user3(View view) {

        Intent intent = new Intent(this, LoginActivity.class);

        Button b3 = (Button) findViewById(R.id.BL_button);

        String username = b3.getText().toString();

        intent.putExtra("USERNAME", username);

        startActivity(intent);
    }

    public void Login_user4(View view) {

        Intent intent = new Intent(this, LoginActivity.class);

        Button b4 = (Button) findViewById(R.id.BR_button);

        String username = b4.getText().toString();

        intent.putExtra("USERNAME", username);

        startActivity(intent);
    }

}

