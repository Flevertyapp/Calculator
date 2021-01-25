package ru.example.mycalc;

import android.util.Log;
import android.widget.Toast;

public class CalculatorLogic {
    private float firstArg;
    private float secondAgr;

    StringBuilder inputStr = new StringBuilder();
    private State state;
    private int actionSelected; //для запоминания выбранного действия

    private enum State {        //задаем состояние, чтоб калк понимал что он сейчас делает
        firstArgInput,          //ввод первого числа
        secondArgInput,         //ввод второго числа
        showResult,             //показ результата
    }

    public CalculatorLogic() {
        state = State.firstArgInput;
    }

    public void numberButtonPressed(int numberButtonID) {
        if (state == State.showResult) {         //если показывали результат, снова вводим первый аргумент
            state = State.firstArgInput;
            inputStr.setLength(0);
        }
        if (inputStr.length() <= 9) {  //ограничение на 10 знаков
            switch (numberButtonID) {
                case R.id.button_0:
                    inputStr.append("0"); //   TODO проверка на количество нулей
                    break;
                case R.id.button_1:
                    inputStr.append("1");
                    break;
                case R.id.button_2:
                    inputStr.append("2");
                    break;
                case R.id.button_3:
                    inputStr.append("3");
                    break;
                case R.id.button_4:
                    inputStr.append("4");
                    break;
                case R.id.button_5:
                    inputStr.append("5");
                    break;
                case R.id.button_6:
                    inputStr.append("6");
                    break;
                case R.id.button_7:
                    inputStr.append("7");
                    break;
                case R.id.button_8:
                    inputStr.append("8");
                    break;
                case R.id.button_9:
                    inputStr.append("9");
                    break;
                case R.id.button_pointer:
                    inputStr.append(".");
                    break;
            }
        }
    }

    public void actionButtonPressed(int actionButtonsID) {
        if (actionButtonsID == R.id.button_equally && state == State.secondArgInput && inputStr.length() != 0) {   //здесь проверяем первое или второе число вводим или показ результат
            secondAgr = Float.parseFloat(inputStr.toString());
            state = State.showResult;
            inputStr.setLength(0); //после показа результата обнуляем строку
            switch (actionSelected) {
                case R.id.button_plus:
                    inputStr.append(firstArg + secondAgr);
                    break;
                case R.id.button_minus:
                    inputStr.append(firstArg - secondAgr);
                    break;
                case R.id.button_multiplication:
                    inputStr.append(firstArg * secondAgr);
                    break;
                case R.id.button_percent:
                    //inputStr.append(firstArg + secondAgr);
                    break;
                case R.id.button_clear:
                    //TODO надо запихнуть в отдельный метод
                    break;
                case R.id.button_delete:
                    //TODO надо запихнуть в отдельный метод
                    break;
                case R.id.button_division:
                    try {
                        inputStr.append(firstArg / secondAgr);
                    } catch (NullPointerException e) {
                        inputStr.append(e.getMessage());
                        inputStr.append("На ноль делить можно только в институте!"); //Не ловится- результат infinity
                    }
                    break;
            }
        } else if (inputStr.length() > 0 && state == State.firstArgInput) {
            firstArg = Float.parseFloat(inputStr.toString());
            state = State.secondArgInput;
            inputStr.setLength(0);
            switch (actionButtonsID) {
                case R.id.button_plus:
                    actionSelected = R.id.button_plus;
                    break;
                case R.id.button_minus:
                    actionSelected = R.id.button_minus;
                    break;
                case R.id.button_multiplication:
                    actionSelected = R.id.button_multiplication;
                    break;
                case R.id.button_percent:
                    actionSelected = R.id.button_percent;
                    break;
                case R.id.button_clear:
                    actionSelected = R.id.button_clear;
                    break;
                case R.id.button_division:
                    actionSelected = R.id.button_division;
                    break;

            }
        }
    }

    public String getText() { //геттер для текста
        return inputStr.toString();
    }
}