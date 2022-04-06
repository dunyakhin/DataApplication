package com.example.firsttrying;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRowFragment extends Fragment implements View.OnClickListener {

EditText et;
Button saveTitleBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View addRow=inflater.inflate(R.layout.fragment_add_row, container,false);
        et=addRow.findViewById(R.id.enterNewTitle);
        saveTitleBtn=addRow.findViewById(R.id.addTitleBtn);
        saveTitleBtn.setOnClickListener(this);
        return addRow;

    }




    @Override
    public void onClick(View view) {
        String text;
        text=et.getText().toString();
        if(text.length()==0){
            Toast.makeText(getContext(), "Введите имя",Toast.LENGTH_LONG).show();
        }else{
            Bundle bundle = new Bundle();
            bundle.putString("resultKey", et.getText().toString());
            getParentFragmentManager().setFragmentResult("requestKey", bundle);
            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.popBackStack();
        }
    }
};
