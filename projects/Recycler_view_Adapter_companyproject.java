package com.example.sagartyagi.projects;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sagar Tyagi on 08-Jul-17.
 */

public class Recycler_view_Adapter_companyproject extends RecyclerView.Adapter<Recycler_view_Adapter_companyproject.myholder> {
    Context context;
    LayoutInflater inflater;
    ArrayList<DataHandler> objectList=new ArrayList<DataHandler>();
    Recycler_view_Adapter_companyproject(Context context,ArrayList<DataHandler> objectList){
        this.objectList=objectList;
        this.context=context;
        inflater=inflater.from(context);
    }

    @Override
    public myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= inflater.inflate(R.layout.templaterow,null,false);
        myholder holder=new myholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(myholder holder, final int position) {
        DataHandler current_handler=objectList.get(position);
        holder.t1.setText(current_handler.getPname());
        holder.t2.setText(current_handler.getPdesription());
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataHandler clickedobject=objectList.get(position);
                BackGroundTask2 task2=new BackGroundTask2(context);
                task2.execute("Adding information",clickedobject.getPname(),clickedobject.getPdesription());
                try {
                    Recycler_view_Adapter_companyproject.this.finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
                Snackbar.make(v,"Project Added",Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    public class myholder extends RecyclerView.ViewHolder {
        TextView t1,t2;
        ImageView img;
        public myholder(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.project_name);
            t2=(TextView)itemView.findViewById(R.id.project_description);
            img=(ImageView)itemView.findViewById(R.id.imageview);
        }
    }
}
