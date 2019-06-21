package com.example.sagartyagi.projects;


import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class YourProject extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
    ArrayList<DataHandler> listobject=new ArrayList<DataHandler>();
    public YourProject() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_your_project, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(layoutManager);
        YourProjectDataBase projectDataBase=new YourProjectDataBase(getContext());
         Cursor result= projectDataBase.takedata();
           if(result !=null&&result.moveToNext()){
               result.moveToFirst();
               do{
                   DataHandler handler2=new DataHandler();
                   handler2.setPname(result.getString(0));
                   handler2.setPdesription(result.getString(1));
                   listobject.add(handler2);

               }while(result.moveToNext());
           }
           projectDataBase.close();
         Recyclerview_Adapter_yourproject yourproject=new Recyclerview_Adapter_yourproject(getContext(),listobject);
             recyclerView.setAdapter(yourproject);
        return  v;
    }

}
