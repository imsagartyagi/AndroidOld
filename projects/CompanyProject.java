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
public class CompanyProject extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getContext());
    ArrayList<DataHandler> objectList=new ArrayList<DataHandler>();
    public CompanyProject() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_company_project, container, false);
        recyclerView=(RecyclerView)v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        CompanyProjectDatabase database=new CompanyProjectDatabase(getContext());
          Cursor result=database.getData();
            if(result!=null){
                result.moveToFirst();
                do{
                    DataHandler data=new DataHandler();
                    data.setPname(result.getString(0));
                    data.setPdesription(result.getString(1));
                    objectList.add(data);


                }while(result.moveToNext());
            }
            database.close();
        Recycler_view_Adapter_companyproject adapter_companyproject=new Recycler_view_Adapter_companyproject(getContext(),objectList) ;
        recyclerView.setAdapter(adapter_companyproject);

        return v;
    }

}
