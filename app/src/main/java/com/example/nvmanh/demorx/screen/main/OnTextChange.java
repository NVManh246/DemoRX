package com.example.nvmanh.demorx.screen.main;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class OnTextChange implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        searchHeros(charSequence.toString());
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public abstract void searchHeros(String key);

}
