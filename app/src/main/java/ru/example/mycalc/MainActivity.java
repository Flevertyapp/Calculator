package ru.example.mycalc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CalculatorLogic calculator = new CalculatorLogic();

    private TextView entryView;
    private TextView resultView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button0;
    private Button buttonPointer;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiplication;
    private Button buttonDivision;
    private Button buttonEqually;
    private Button buttonDel;
    private Button buttonSetting;

    int resetCount = 0;
    int eqCount = 0;
    boolean flag = false;
    boolean pointerFlag = false;

    private final static String KeyHistory = "history";
    private final static int THEME_KEY = 99;
    private static int CURRENT_THEME;
    final static String THEME = "THEME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (CURRENT_THEME == 0) {
            setTheme(R.style.StyleLight);
        } else {
            setTheme(R.style.StyleDark);
        }
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        entryView = findViewById(R.id.entry_view);
        resultView = findViewById(R.id.result_view);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonPointer = findViewById(R.id.button_pointer);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonMultiplication = findViewById(R.id.button_multiplication);
        buttonDivision = findViewById(R.id.button_division);
        buttonEqually = findViewById(R.id.button_equally);
        buttonDel = findViewById(R.id.button_del);
        buttonSetting = findViewById(R.id.setting_button);
        setButtonListener();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.button_1):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 1));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 1));
                }
                resetCount = 0;
                break;
            case (R.id.button_2):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 2));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 2));
                }
                resetCount = 0;
                break;
            case (R.id.button_3):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 3));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 3));
                }
                resetCount = 0;
                break;
            case (R.id.button_4):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 4));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 4));
                }
                resetCount = 0;
                break;
            case (R.id.button_5):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 5));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 5));
                }
                resetCount = 0;
                break;
            case (R.id.button_6):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 6));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 6));
                }
                resetCount = 0;
                break;
            case (R.id.button_7):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 7));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 7));
                }
                resetCount = 0;
                break;
            case (R.id.button_8):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 8));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 8));
                }
                resetCount = 0;
                break;
            case (R.id.button_9):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 9));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 9));
                }
                resetCount = 0;
                break;
            case (R.id.button_0):
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%d", 0));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%d", 0));
                }
                resetCount = 0;
                break;
            case (R.id.button_pointer): //TODO провека на количество точек, с флагом некорректно работает
                if (resultView.getText().toString().equals("0") || eqCount > 0) {
                    resultView.setText(String.format("%s", "0."));
                    eqCount = 0;
                } else {
                    resultView.append(String.format("%c", '.'));
                }
                resetCount = 0;

                break;
            case (R.id.button_minus):
                if (flag == false) {
                    eqCount = 0;
                    resultView.append(String.format("%c", '-'));
                    flag = true;
                }
                break;
            case (R.id.button_plus):
                if (!flag) {
                    eqCount = 0;
                    resultView.append(String.format("%c", '+'));
                    flag = true;
                }
                break;
            case (R.id.button_multiplication):
                if (!flag) {
                    eqCount = 0;
                    resultView.append(String.format("%c", '*'));
                    flag = true;
                }
                break;
            case (R.id.button_division):
                if (!flag) {
                    eqCount = 0;
                    resultView.append(String.format("%c", '/'));
                    flag = true;
                }
                break;
            case (R.id.button_del):
                resetCount++;
                eqCount = 0;
                if (resetCount == 2) {
                    entryView.setText(" ");
                    calculator.setEntryView(" ");
                    resetCount = 0;
                }
                resultView.setText("0");
                calculator.setResult(0);
                calculator.setResultView(" ");
                flag = false;
                pointerFlag = false;
                break;
            case (R.id.button_equally):
                eqCount++;
                calculator.calculationMethod(resultView.getText().toString());
                resultView.setText(calculator.getResultView());
                entryView.setText(calculator.getEntryView());
                flag = false;
                pointerFlag = false;
                break;
            case (R.id.setting_button):
                Intent settingActivity = new Intent(this, Settings.class); //open settings
                startActivityForResult(settingActivity, THEME_KEY);
        }
    }

    private void setButtonListener() {
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button0.setOnClickListener(this);
        buttonPointer.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonEqually.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonSetting.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (calculator.getResultView() == null) {
            calculator.setResultView("0");
        }
        outState.putParcelable(KeyHistory, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        calculator = savedInstanceState.getParcelable(KeyHistory);
        setCalculationHistory(calculator.getResultView(), calculator.getEntryView());
    }

    private void setCalculationHistory(String result, String history) {
        entryView.setText(String.format("%s", history));
        resultView.setText(String.format("%s", result));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //проверяем какая тема и меняем по пришедшему инту
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != THEME_KEY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        if (resultCode == RESULT_OK) {
            //CURRENT_THEME = data.getExtras().getInt(THEME); //может выпасть в НПО
            recreate();
        }
    }

}