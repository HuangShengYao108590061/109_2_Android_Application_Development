package com.example.android.a108590061_hw5_part_1;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.util.Log;
import android.os.Bundle;

public class MainActivity extends Activity {

    private TextView res;
    private Calculator calc;
    private EditText firstinp;
    private EditText secinp;
    private static final String TAG = "CalculatorActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        res = findViewById(R.id.the_result);
        firstinp = findViewById(R.id.InpOne);
        secinp = findViewById(R.id.InpTwo);
        calc = new Calculator();

    }

    private static Double OPRinp(EditText oprd) {

        String inpt = OPRinpusr(oprd);

        return Double.valueOf(inpt);

    }

    private static String OPRinpusr(EditText oprds) {

        String inpts = oprds.getText().toString();

        if (TextUtils.isEmpty(inpts)) {

            throw new NumberFormatException("Input cannot be empty !");

        }

        return inpts;
    }


    private void theInp(Calculator.OPRT oprtr) {

        double firstOPinp ;

        double secOPinp;
        try {

            firstOPinp = OPRinp(firstinp);
            secOPinp = OPRinp(secinp);

        }

        catch (NumberFormatException nfe) {

            Log.e(TAG, "NumberFormatException", nfe);
            res.setText(getString(R.string.errormsg));
            return;

        }

        String OPres;

        switch (oprtr) {

            case ADDITION:
                OPres = String.valueOf(calc.Additions(firstOPinp, secOPinp));
                break;

            case SUBTRACT:
                OPres = String.valueOf(calc.Subtractions(firstOPinp, secOPinp));
                break;

            case MULTIPLY:
                OPres = String.valueOf(calc.Multiplications(firstOPinp,secOPinp));
                break;

            case DIVISION:
                OPres = String.valueOf(calc.Divisions(firstOPinp, secOPinp));
                break;

            case POWER:
                OPres = String.valueOf(calc.Powers(firstOPinp, secOPinp));
                break;

            default:
                OPres = getString(R.string.errormsg);
                break;

        }

        res.setText(OPres);

    }

    public void onAdd(View view) {

        theInp(Calculator.OPRT.ADDITION);

    }

    public void onSub(View view) {

        theInp(Calculator.OPRT.SUBTRACT);

    }

    public void onDiv(View view) {
        try {

            theInp(Calculator.OPRT.DIVISION);

        } catch (IllegalArgumentException iae) {

            Log.e(TAG, "IllegalArgumentException", iae);
            res.setText(getString(R.string.errormsg));

        }
    }

    public void onMul(View view) {

        theInp(Calculator.OPRT.MULTIPLY);

    }

    public void onPow(View view) {

        theInp(Calculator.OPRT.POWER);

    }

}

