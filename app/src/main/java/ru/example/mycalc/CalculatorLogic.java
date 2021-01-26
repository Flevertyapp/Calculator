package ru.example.mycalc;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculatorLogic implements Parcelable {

    private String entryView;
    private String resultView = " ";
    private float result;

    protected CalculatorLogic(Parcel in) {
        entryView = in.readString();
        resultView = in.readString();
    }

    public CalculatorLogic() {
    }

    public void calculationMethod(String result) {
        int i = 0;
        if (result.indexOf('+') != -1) {
            String[] values = result.split("\\+");
            if (values.length < 2) {
                resultView = "0";
                return;
            }
            Float number1 = Float.valueOf(values[0]);
            Float number2 = Float.valueOf(values[1]);
            this.result = number1 + number2;
            i++;
        } else if (result.indexOf('-') != -1) {
            String[] values = result.split("-");
            if (values.length < 2) {
                resultView = "0";
                return;
            }
            Float number1 = Float.valueOf(values[0]);
            Float number2 = Float.valueOf(values[1]);
            this.result = number1 - number2;
            i++;
        } else if (result.indexOf('*') != -1) {
            String[] values = result.split("\\*");
            if (values.length < 2) {
                resultView = "0";
                return;
            }
            Float number1 = Float.valueOf(values[0]);
            Float number2 = Float.valueOf(values[1]);
            this.result = number1 * number2;
            i++;
        } else if (result.indexOf('/') != -1) {
            String[] values = result.split("/");
            if (values.length < 2) {
                resultView = "0";
                return;
            }
            Float number1 = Float.valueOf(values[0]);
            Float number2 = Float.valueOf(values[1]);
            this.result = number1 / number2;
            i++;
        } else {
            i = 0;
        }
        if (i != 0) {
            entryView += String.format("%s \n", result);
        }
        if (this.result % 1 == 0) {
            resultView = String.format("%s", (int) this.result);
        } else {
            resultView = String.format("%s", this.result);
        }
    }

    public static final Creator<CalculatorLogic> CREATOR = new Creator<CalculatorLogic>() {
        @Override
        public CalculatorLogic createFromParcel(Parcel in) {
            return new CalculatorLogic(in);
        }

        @Override
        public CalculatorLogic[] newArray(int size) {
            return new CalculatorLogic[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(resultView);
        parcel.writeString(entryView);
    }

    public String getEntryView() {
        return entryView;
    }

    public void setEntryView(String entryView) {
        this.entryView = entryView;
    }

    public String getResultView() {
        return resultView;
    }

    public void setResultView(String resultView) {
        this.resultView = resultView;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }
}


