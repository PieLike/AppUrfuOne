package com.example.pielikes.appurfuone;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import static com.example.pielikes.appurfuone.R.id.container;
import static com.example.pielikes.appurfuone.R.id.view;

public class FragmentCalendar extends Fragment {

    public Elements content;
    public Element link;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        newCalendar();
        View view = inflater.inflate(R.layout.fragment_calendar,container, false);

        MyTask mt = new MyTask();
        mt.execute();

 //       Toast.makeText(getActivity(), link.ownText() ,Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_calendar, container, false);
    }

    public void newCalendar() {
        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.START_DAY_OF_WEEK, CaldroidFragment.MONDAY);
        args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, false);
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
     //   PutInfo(2011-04-13 05:00);
        caldroidFragment.setArguments(args);
    //    listener.onSelectDate(date );

        FragmentTransaction t = getFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();

        final CaldroidListener listener = new CaldroidListener() {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            private Context Context;
            @Override
            public void onSelectDate(Date date, View view) {
             //   Toast.makeText(Context.getApplicationContext(), formatter.format(date), Toast.LENGTH_SHORT).show();
            //    CaldroidFragment dialogCaldroidFragment = CaldroidFragment.newInstance("lfnf", 3, 2013);
            //    dialogCaldroidFragment.show(getFragmentManager(),"TAG");
            }
/*
            @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                Toast.makeText(Context.getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongClickDate(Date date, View view) {
                Toast.makeText(Context.getApplicationContext(), "Long click " + formatter.format(date), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCaldroidViewCreated() {
                Toast.makeText(Context.getApplicationContext(), "Caldroid view is created", Toast.LENGTH_SHORT).show();
            }*/
        };
        caldroidFragment.setCaldroidListener(listener);
    }

    class MyTask extends AsyncTask<Void, Void, Void> {

        String title;
        Elements testElement;

        @Override
        protected Void doInBackground(Void... params) {

            Document doc = null;
            try {
                doc = Jsoup.connect("https://urfu.ru/ru/events").get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (doc!=null) {
                title = doc.title();
                testElement = doc.getElementsByTag("m-bot");
            }else
                title = "Ошибка";

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

 //           name.setText(title);
 //           Toast.makeText(getActivity(), title ,Toast.LENGTH_SHORT).show();
        }
    }



    public void PutInfo(Date date){
        CaldroidFragment caldroidFragment = new CaldroidFragment();
        Map <String, Object> extraData = caldroidFragment.getExtraData();
        extraData.put("YOUR_CUSTOM_DATA_KEY1", date);
        extraData.put("YOUR_CUSTOM_DATA_KEY2", date);

    }

}
