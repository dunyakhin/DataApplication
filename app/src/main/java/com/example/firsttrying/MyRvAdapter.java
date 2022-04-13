package com.example.firsttrying;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firsttrying.room.DatabaseUnit;

import java.util.ArrayList;
import java.util.List;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder> {
    List<DatabaseUnit> items=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ViewHolder viewHolder= new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false));
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    DatabaseUnit data=items.get(position);
    holder.et1.setText(data.coord);
        holder.et2.setText(data.ipi);
        holder.et3.setText(data.km);
        holder.et4.setText(data.ve);
        holder.et5.setText(data.note);

        holder.et1.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.km=(editable.toString());

            }
        });
        holder.et2.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.coord=(editable.toString());

            }
        });
        holder.et3.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.ipi=(editable.toString());

            }
        });
        holder.et4.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.ve=(editable.toString());

            }
        });
        holder.et5.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.note=(editable.toString());

            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();

    }
    public void updateItems(List <DatabaseUnit> items){

        this.items=items;
       notifyItemChanged(getItemCount());

    }


    class ViewHolder extends RecyclerView.ViewHolder{
        EditText et1, et2,et3,et4,et5;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            et1=itemView.findViewById(R.id.et1);
            et2=itemView.findViewById(R.id.et2);
            et3=itemView.findViewById(R.id.et3);
            et4=itemView.findViewById(R.id.et4);
            et5=itemView.findViewById(R.id.et5);
        }
    }
    public void clearData(){
        items.clear();
    }
}
