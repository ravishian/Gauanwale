package com.Soni5.gauanwale.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.Soni5.gauanwale.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class AddFragment extends Fragment {


    public AddFragment() {
        // Required empty public constructor
    }

    EditText name , address , age , mobile;
    Spinner medicine;
    Button btn;


    SimpleDateFormat formatter=new SimpleDateFormat("dd:MM:yyyy ");
    Date date=new Date();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_add, container, false);

        HashMap<String , String > v = new HashMap<>();

        String names , adress , ages,mobiles,dates,spinners,photo;
        dates = date.toString();
        String id = String.valueOf(Math.random());
        name = view.findViewById(R.id.addname);
        address = view.findViewById(R.id.addadress);
        age = view.findViewById(R.id.addage);
        mobile = view.findViewById(R.id.addmobile);
        btn  = view.findViewById(R.id.sumbitbutton);
        medicine = view.findViewById(R.id.spinner);

        String[]Medicine={"India","USA","China","Japan","Other"};

        ages = age.getText().toString();
        names = name.getText().toString();
        adress = address.getText().toString();
        mobiles = mobile.getText().toString();
        spinners = "hee";

        //ArrayAdapter aa = new ArrayAdapter(android.R.layout.simple_spinner_item,Medicine);
            //    aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner  
            // medicine.setAdapter(aa);

            

        v.put("Id",id);
        v.put("Name",names);
        v.put("Address",adress);
        v.put("Mobile",mobiles);
        v.put("Medicine",spinners);
        v.put("Date",dates);
        v.put("Age",ages);



        return  view;


    }
}