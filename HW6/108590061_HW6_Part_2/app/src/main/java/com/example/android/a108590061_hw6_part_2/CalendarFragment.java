package com.example.android.a108590061_hw6_part_2;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.annotation.NonNull;
import android.widget.DatePicker;
import java.util.Calendar;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.widget.TextView;
import java.util.Objects;


public class CalendarFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar clndr = Calendar.getInstance();

        int Selected_Day = clndr.get(Calendar.DAY_OF_MONTH);
        int Selected_Month = clndr.get(Calendar.MONTH);
        int Selected_Year = clndr.get(Calendar.YEAR);

        return new DatePickerDialog(getActivity(), this, Selected_Year, Selected_Month, Selected_Day);
    }

    @Override
    public void onDateSet(DatePicker view, int Selected_Year, int Selected_Month, int Selected_Day_oM) {

        OrderActivity Ord_Act = (OrderActivity) getActivity();

        if (Ord_Act != null) { Ord_Act.ResCalendarPickDate(Selected_Year, Selected_Month, Selected_Day_oM); }

    }
}


