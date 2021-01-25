package ru.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

   /* private CalculatorLogic calculator = new CalculatorLogic();
    private TextView textView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*int[] numberButtonsID = new int[]{      //массив айдишников цифровых кнопок
                R.id.button_0,
                R.id.button_1,
                R.id.button_2,
                R.id.button_3,
                R.id.button_4,
                R.id.button_5,
                R.id.button_6,
                R.id.button_7,
                R.id.button_8,
                R.id.button_9,
                R.id.button_pointer
        };

        int[] actionButtonsID = new int[]{      //массив айдишников кнопок действий
                R.id.button_plus,
                R.id.button_minus,
                R.id.button_multiplication,
                R.id.button_percent,
                R.id.button_clear,
                R.id.button_delete,
                R.id.button_division,
                R.id.button_equally
        };

        textView = findViewById(R.id.text_view);
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {   //слушатель для числовых кнопок
            @Override
            public void onClick(View v) {
                calculator.numberButtonPressed(v.getId());  //получаем id
                textView.setText(calculator.getText());  //вытягиваем текст
            }
        };

        View.OnClickListener actionButtonClickListener = new View.OnClickListener() {   ////слушатель для кнопок действий
            @Override
            public void onClick(View v) {
                calculator.actionButtonPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numberButtonsID.length; i++) {          //вытягиваем id нажатой кнопки
            findViewById(numberButtonsID[i]).setOnClickListener(numberButtonClickListener);
        }

        for (int i = 0; i < actionButtonsID.length; i++) {
            findViewById(actionButtonsID[i]).setOnClickListener(actionButtonClickListener);
        }*/

    }
}