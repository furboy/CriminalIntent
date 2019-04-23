package com.ctech.aleco.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    private static final String ARG_DATE ="crime_date";
    public static final String EXTRA_DATE = "com.ctech.aleco.criminalintent.date";
    private DatePicker mDatePicker;

    public static DatePickerFragment newInstance(Date date){
        Bundle args = new Bundle();
        args.putSerializable(ARG_DATE, date);

        DatePickerFragment myFragment = new DatePickerFragment();
        myFragment.setArguments(args);
        return myFragment;
    }

    View v = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);

    @Override
    @NonNull
    public Dialog   onCreateDialog(@Nullable Bundle savedInstanceState){

        private final void sendResult(int resultCode, Date date;
        date){
            if (getTargetFragment() == null){
                return null;
            }
            Intent myIntent = new Intent();
            myIntent.putExtra(EXTRA_DATE, date);

            getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, myIntent);
        }

        Date myDate = (Date) getArguments().getSerializable(ARG_DATE);

        Calendar myCalendar = Calendar.getInstance();
        myCalendar.setTime(myDate);
        int year = myCalendar.get(Calendar.YEAR);
        int month = myCalendar.get(Calendar.MONTH);
        int day = myCalendar.get(Calendar.DAY_OF_MONTH);


        mDatePicker = (DatePicker) v.findViewById(R.id.dialog_date_picker);
        mDatePicker.init(year, month, day, null);


        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int year = mDatePicker.getYear();
                        int month = mDatePicker.getMonth();
                        int day = mDatePicker.getDayOfMonth();
                        Date myDate = new GregorianCalendar(year,month,day).getTime();
                        sendResult(Activity.RESULT_OK, myDate);
                    }
                })
                .create();
    }
}
