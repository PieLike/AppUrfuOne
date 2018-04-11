package com.example.pielikes.appurfuone;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class FragmentList extends Fragment {

    ListView listView;

    ArrayList<String> items;

    String[] data = {"все", "бюджет", "небюджет"};

    MenuItem searchItem;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list,container, false);

        // адаптер
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, data);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setAdapter(adapter2);
        // заголовок
        spinner.setPrompt("Title");
        // выделяем элемент
        spinner.setSelection(0);
        // устанавливаем обработчик нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // показываем позиция нажатого элемента

                if (position == 0){
                    ArrayList<String> templist = new ArrayList<String>();

                    for(String temp:items){
                            templist.add(temp);
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, templist);
                    listView.setAdapter(adapter);
                } else if (position == 1){
                    ArrayList<String> templist = new ArrayList<String>();
                    int num = 0;
                    String number;
                    String str;
                    for(String temp:items){
                        number = String.valueOf(num + 1);

                        str = (getResources().getString(getResources().
                                getIdentifier("NAPR_plasesFT_"+number, "string", getActivity().getPackageName())));
                        if(str.contains("Бюджетных")){
                            templist.add(temp);
                        }
                        num = num + 1;
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, templist);
                    listView.setAdapter(adapter);
                } else if (position == 2){
                    ArrayList<String> templist = new ArrayList<String>();
                    int num = 0;
                    String number;
                    String str;
                    for(String temp:items){
                        number = String.valueOf(num + 1);

                        str = (getResources().getString(getResources().
                                getIdentifier("NAPR_plasesFT_"+number, "string", getActivity().getPackageName())));
                        if(str.contains("Внебюджетных")){
                            templist.add(temp);
                        }
                        num = num + 1;
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, templist);
                    listView.setAdapter(adapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        listView = (ListView) view.findViewById(R.id.list_item_search);

        items = new ArrayList<>();
        items.add(getString(R.string.NAPR_name_1) + "\n" + getString(R.string.NAPR_code_1));
        items.add(getString(R.string.NAPR_name_2) + "\n" + getString(R.string.NAPR_code_2));
        items.add(getString(R.string.NAPR_name_3) + "\n" + getString(R.string.NAPR_code_3));
  //      items.add("3");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView<?> adapterView, View view, int i, long l){
                String text = listView.getItemAtPosition(i).toString();
                String number = String.valueOf(i + 1);
          //      Toast.makeText(view.getContext(), "" + text ,Toast.LENGTH_SHORT).show();
         /*       if (text == getString(R.string.NAPR_name_001) + "\n" + getString(R.string.NAPR_code_001)){
                    Intent intent = new Intent(view.getContext(), DirectionBI.class);
                    intent.putExtra("info", number);
                    startActivity(intent);
                } else if (text == getString(R.string.list_002)){
                    Intent intent = new Intent(view.getContext(), InstituteEIM.class);
                    intent.putExtra("info", number);
                    startActivity(intent);
                }*/

                Intent intent = new Intent(view.getContext(), DirectionBI.class);
                intent.putExtra("info", number);
                startActivity(intent);


            }
        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        searchItem = menu.findItem(R.id.item_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextChange(String newText){
                ArrayList<String> templist = new ArrayList<String>();

                for(String temp:items){
                    if(temp.toLowerCase().contains(newText.toLowerCase())){
                        templist.add(temp);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, templist);
                listView.setAdapter(adapter);

                return true;
            }

            @Override
            public boolean onQueryTextSubmit (String query){
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
}






















