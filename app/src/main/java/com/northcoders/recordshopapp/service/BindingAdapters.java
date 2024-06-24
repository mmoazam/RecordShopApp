package com.northcoders.recordshopapp.service;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

public class BindingAdapters {
    @BindingAdapter("android:text")
    public static void setInt(EditText view, int value) {
        if (!view.getText().toString().equals(String.valueOf(value))) {
            view.setText(String.valueOf(value));
        }
    }

    @InverseBindingAdapter(attribute = "android:text", event = "android:textAttrChanged")
    public static int getInt(EditText view) {
        String value = view.getText().toString();
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    @BindingAdapter("android:textAttrChanged")
    public static void setListeners(EditText view, final InverseBindingListener attrChange) {
        view.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                attrChange.onChange();
            }
        });
    }
}
