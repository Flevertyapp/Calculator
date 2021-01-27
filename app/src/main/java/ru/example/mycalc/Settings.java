package ru.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private Button darkButton;
    private Button lightButton;
    private Button returnButton;
    private static int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (theme == 0) {
            setTheme(R.style.StyleLight);
        } else {
            setTheme(R.style.StyleDark);
        }
        setContentView(R.layout.activity_settings_activity);
        initView();
    }

    private void initView() {
        darkButton = findViewById(R.id.dark_button);
        lightButton = findViewById(R.id.light_button);
        returnButton = findViewById(R.id.return_button);
        setButtonClickListener();
    }

    private void setButtonClickListener() {
        darkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                theme = 1;
                recreate();
            }
        });
        lightButton.setOnClickListener(v -> {
            theme = 0;
            recreate();
        });
        returnButton.setOnClickListener(v -> {
            Intent returnToMain = new Intent();
            returnToMain.putExtra(MainActivity.THEME, theme);
            setResult(RESULT_OK, returnToMain);
            finish();
        });
    }
}