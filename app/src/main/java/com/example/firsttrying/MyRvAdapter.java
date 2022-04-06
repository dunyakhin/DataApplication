package com.example.firsttrying;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.ViewHolder> {
    List<RowData> items=new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       ViewHolder viewHolder= new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false));
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    RowData data=items.get(position);
    holder.et1.setText(data.getField1());
        holder.et2.setText(data.getField2());
        holder.et3.setText(data.getField3());
        holder.et4.setText(data.getField4());
        holder.et5.setText(data.getField5());

        holder.et1.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.setField1(editable.toString());

            }
        });
        holder.et2.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.setField2(editable.toString());

            }
        });
        holder.et3.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.setField3(editable.toString());

            }
        });
        holder.et4.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.setField4(editable.toString());

            }
        });
        holder.et5.addTextChangedListener(new BaseTextWatcher() {

            @Override
            public void afterTextChanged(Editable editable) {
                data.setField5(editable.toString());

            }
        });
    }


    @Override
    public int getItemCount() {
        return items.size();

    }
    void updateItems(List <RowData> items){
        this.items=items;
        notifyDataSetChanged();
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
}
