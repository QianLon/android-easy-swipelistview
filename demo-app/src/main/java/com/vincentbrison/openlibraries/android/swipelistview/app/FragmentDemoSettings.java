package com.vincentbrison.openlibraries.android.swipelistview.app;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vincentbrison.openlibraries.android.swipelistview.id.R;

public class FragmentDemoSettings extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_demo_settings, null);
        return rootView;
    }
}
