package com.leonus96.joseph.siscolegio.Fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leonus96.joseph.siscolegio.R;
import com.stacktips.view.CustomCalendarView;
import com.stacktips.view.DayDecorator;
import com.stacktips.view.DayView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AsistenciaFragment extends Fragment {

    @BindView(R.id.calendar_view) CustomCalendarView _calendar;


    public AsistenciaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_asistencia, container, false);
        ButterKnife.bind(this, view);
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());


        _calendar.setShowOverflowDate(false);

        List asistencia = new ArrayList<>();
        asistencia.add(new AsistenciaColor());
        _calendar.setDecorators(asistencia);
        _calendar.refreshCalendar(currentCalendar);





        return view;
    }

    private class AsistenciaColor implements DayDecorator{

        @Override
        public void decorate(DayView dayView) {
            Date date = dayView.getDate();
            int day = date.getDate();
            Date falta1 = new Date();
            Date falta2 = new Date();
            //TODO: Aqui se define asistencia
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                falta1 = sdf.parse("2017-03-02");
                falta2 = sdf.parse("2017-03-03");
            } catch (ParseException e) {
                e.printStackTrace();
            }
            int f1 = falta1.getDate();
            int f2 = falta2.getDate();
            if(day == f1 || day == f2){
                int color = Color.parseColor("#ED7777");
                dayView.setBackgroundColor(color);


            }else{
                int color = Color.parseColor("#A4DEAE");
                dayView.setBackgroundColor(color);
            }

        }
    }

}
