package br.com.heiderlopes.demoactionbarfull.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import br.com.heiderlopes.demoactionbarfull.fragment.AndroidFragment;
import br.com.heiderlopes.demoactionbarfull.fragment.IosFragment;
import br.com.heiderlopes.demoactionbarfull.fragment.WindowsPhoneFragment;

public class TabsAdapter extends FragmentStatePagerAdapter{

    private int TOTAL_TABS = 3;

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {
        // TODO Auto-generated method stub
        switch (index) {
            case 0:
                return new IosFragment();
            case 1:
                return new WindowsPhoneFragment();
            case 2:
                return new AndroidFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return TOTAL_TABS;
    }
}