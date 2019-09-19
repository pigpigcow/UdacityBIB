package com.example.displayjoke;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayJoke extends AppCompatActivity {
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            Intent intent = getIntent();
            if (intent == null) {
                closeOnError();
            }

            try {
                msg = intent.getStringExtra(Intent.EXTRA_TEXT);
            } catch (NullPointerException e) {
                e.printStackTrace();
                closeOnError();
                return;
            }
        } else {
            msg = savedInstanceState.getString(this.getClass().getSimpleName());
        }
        setUI();
    }

    private void setUI() {
        final String[] msgData = msg.split(",");
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, msgData[1], Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView mainTV = findViewById(R.id.main_tv);
        mainTV.setText(msgData[0]);
    }

    private void closeOnError() {
        Toast.makeText(this, R.string.load_error, Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString(this.getClass().getSimpleName(), msg);
        super.onSaveInstanceState(outState);
    }
}
