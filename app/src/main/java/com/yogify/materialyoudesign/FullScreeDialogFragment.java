package com.yogify.materialyoudesign;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

public class FullScreeDialogFragment extends DialogFragment {

    static FullScreeDialogFragment newInstance() {
        FullScreeDialogFragment f = new FullScreeDialogFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fullscreendilog, container, false);
        return v;
    }

}