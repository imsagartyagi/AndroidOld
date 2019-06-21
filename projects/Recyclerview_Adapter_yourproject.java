package com.example.sagartyagi.projects;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sagar Tyagi on 09-Jul-17.
 */

public class Recyclerview_Adapter_yourproject extends RecyclerView.Adapter<Recyclerview_Adapter_yourproject.myviewholder2> {
    ArrayList<DataHandler> listobject=new ArrayList<DataHandler>();
    Context context;
    LayoutInflater inflater;

    Recyclerview_Adapter_yourproject(Context context,ArrayList<DataHandler> listobject){
        this.context=context;
        this.listobject=listobject;
        inflater=inflater.from(context);
    }

    @Override
    public myviewholder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =inflater.inflate(R.layout.templaterow2,null,false);
        myviewholder2 holder2 = new myviewholder2(view);
        return holder2;
    }

    @Override
    public void onBindViewHolder(myviewholder2 holder, int position) {
        DataHandler currentposition=listobject.get(position);
        holder.t1.setText(currentposition.getPname());
        holder.t2.setText(currentposition.getPdesription());
    }

    @Override
    public int getItemCount() {
        return listobject.size();
    }
    public class  myviewholder2 extends RecyclerView.ViewHolder {
        TextView t1,t2;
        public myviewholder2(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.projectName);
            t2=(TextView)itemView.findViewById(R.id.projectDescription);
        }
    }

}
