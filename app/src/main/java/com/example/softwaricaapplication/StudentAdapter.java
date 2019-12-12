package com.example.softwaricaapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter<StudentsViewHolder> extends RecyclerView.Adapter<StudentAdapter.StudentsViewHolder> {

    Context mContext;
    List<Students> studentsList;

    //constructor to recieve the data from activity

    public StudentAdapter(List<Students> studentsList)
    {
        this.studentsList = studentsList;
    }



    @NonNull
    @Override
    public StudentAdapter.StudentsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.studentdetails, parent, false);


        return new StudentAdapter.StudentsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.StudentsViewHolder holder, final int position)
    {
        final Students students = studentsList.get(position);
        holder.imggender.setImageResource(students.getImggender());
        holder.txtname.setText(students.getName());
        holder.txtage.setText(String.valueOf(students.getAge()));
        holder.txtaddress.setText(students.getAddress());
        holder.txtgender.setText(students.getGender());
        holder.imgbtndelete.setImageResource(students.getImgbtndelete());

        holder.imgbtndelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Students removeItems = studentsList.get(position);

                //remove item from the list
                studentsList.remove(position);

                //notify adapter about the removal of item
                notifyItemRemoved(position);


            }
        });

    }


    @Override
    public int getItemCount()
    {
        return studentsList.size();
    }



    public class StudentsViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imggender;
        TextView txtname, txtage, txtaddress, txtgender;
        ImageButton imgbtndelete;

        public StudentsViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imggender = itemView.findViewById(R.id.imggender);
            txtname = itemView.findViewById(R.id.txtname);
            txtage = itemView.findViewById(R.id.txtage);
            txtaddress = itemView.findViewById(R.id.txtaddress);
            txtgender = itemView.findViewById(R.id.txtgender);
            imgbtndelete = itemView.findViewById(R.id.imgbtndelete);


        }
    }
}
