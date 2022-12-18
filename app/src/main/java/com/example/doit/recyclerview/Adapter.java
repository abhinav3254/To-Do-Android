package com.example.doit.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doit.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<ModelClass> userList;

    public Adapter(List<ModelClass>userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.showitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        String c = userList.get(position).getCategory();
        String m = userList.get(position).getMessage();
        String d = userList.get(position).getDate();
        String t = userList.get(position).getTime();

        holder.setData(c,m,d,t);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView category;
        private TextView message;
        private TextView date;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            category = itemView.findViewById(R.id.categoryNameSI);
            message = itemView.findViewById(R.id.messageSI);
            date = itemView.findViewById(R.id.dateSI);
            time = itemView.findViewById(R.id.timeSI);



        }

        public void setData(String c, String m, String d, String t) {
            category.setText(c);
            message.setText(m);
            date.setText(d);
            time.setText(t);
        }
    }
}
