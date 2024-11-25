package com.example.test_btl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;

import com.google.android.material.button.MaterialButton;

public class AddSourceDialogFragment extends DialogFragment {

    private EditText edtSourceName, edtAmount, edtFromWhere;
    private MaterialButton btnAdd, btnCancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_add_source, container, false);

        edtSourceName = view.findViewById(R.id.edtSourceName);
        edtAmount = view.findViewById(R.id.edtAmount);
        edtFromWhere = view.findViewById(R.id.edtFromWhere);
        btnAdd = view.findViewById(R.id.btnAdd);
        btnCancel = view.findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(v -> {
            String sourceName = edtSourceName.getText().toString();
            String amount = edtAmount.getText().toString();
            String fromWhere = edtFromWhere.getText().toString();

            if (sourceName.isEmpty() || amount.isEmpty() || fromWhere.isEmpty()) {
                Toast.makeText(getContext(), "Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Thêm nguồn tiền thành công!", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        btnCancel.setOnClickListener(v -> dismiss());

        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }

        return view;
    }
}
