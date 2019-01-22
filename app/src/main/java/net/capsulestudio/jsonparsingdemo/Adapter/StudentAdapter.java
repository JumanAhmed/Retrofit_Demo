package net.capsulestudio.jsonparsingdemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.capsulestudio.jsonparsingdemo.Model.Student;
import net.capsulestudio.jsonparsingdemo.R;

import java.util.ArrayList;

public class StudentAdapter extends ArrayAdapter {
    public Context context;
    public  int resID;
    ArrayList<Student> dataList;

    public StudentAdapter(Context context, int resource, ArrayList<Student> dataList) {
        super(context, resource, dataList);

        this.context = context;
        this.resID  = resource;
        this.dataList = dataList;

    }


    @Override
    public int getCount() {
        return dataList.size();
    }



    public  class ViewHolder{
        TextView tvName, tvEmail, tvPhone, tvUniversity;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            ViewHolder viewHolder;

            if (view == null){

                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(resID, null);
                viewHolder = new ViewHolder();

                viewHolder.tvName =  view.findViewById(R.id.tv_name);
                viewHolder.tvPhone =  view.findViewById(R.id.tv_phone);
                viewHolder.tvEmail =  view.findViewById(R.id.tv_email);
                viewHolder.tvUniversity =  view.findViewById(R.id.tv_university);

                view.setTag(viewHolder);

            }else {
                viewHolder = (ViewHolder) view.getTag();

            }


                Student dataModel = dataList.get(position);

                viewHolder.tvName.setText(dataModel.getName());
                viewHolder.tvEmail.setText(dataModel.getEmail());
                viewHolder.tvPhone.setText(dataModel.getPhone());
                viewHolder.tvUniversity.setText(dataModel.getUniversity());


                return view;

    }


}
