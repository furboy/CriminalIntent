package com.ctech.aleco.criminalintent;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import java.util.Date;

public class DatePickerFragment extends DialogFragment {

    private static final String ARG_DATE ="crime_date";
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
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.date_picker_title)
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
