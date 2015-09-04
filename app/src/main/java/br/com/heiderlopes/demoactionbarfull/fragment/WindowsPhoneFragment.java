package br.com.heiderlopes.demoactionbarfull.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.com.heiderlopes.demoactionbarfull.R;


public class WindowsPhoneFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_windows_phone, container, false);

        return view;
    }
}