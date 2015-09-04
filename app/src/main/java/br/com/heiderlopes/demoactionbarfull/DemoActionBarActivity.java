package br.com.heiderlopes.demoactionbarfull;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.heiderlopes.demoactionbarfull.adapter.TabsAdapter;

public class DemoActionBarActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private TabsAdapter mTabsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_actionbar);

        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);
        mTabsAdapter = new TabsAdapter(getSupportFragmentManager());
        tabsviewPager.setAdapter(mTabsAdapter);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.ic_launcher));
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab iosTab = getSupportActionBar().newTab().setText(getString(R.string.tab_ios)).setTabListener(this);
        iosTab.setIcon(R.drawable.ic_tab_ios);
        Tab windowsPhoneTab = getSupportActionBar().newTab().setText(getString(R.string.tab_windows_phone)).setTabListener(this);
        windowsPhoneTab.setIcon(R.drawable.ic_tab_wp);
        Tab androidTab = getSupportActionBar().newTab().setText(getString(R.string.tab_android)).setTabListener(this);
        androidTab.setIcon(R.drawable.ic_tab_android);

        getSupportActionBar().addTab(iosTab);
        getSupportActionBar().addTab(windowsPhoneTab);
        getSupportActionBar().addTab(androidTab, true);

        /*if(savedInstanceState != null) {
            getSupportActionBar().setSelectedNavigationItem(savedInstanceState.getInt("indiceTab"));
        } else {
            getSupportActionBar().setSelectedNavigationItem(0);
        }*/

        //This helps in providing swiping effect for v7 compat library
        tabsviewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {


    }

    @Override
    public void onTabSelected(Tab selectedtab, FragmentTransaction arg1) {
        tabsviewPager.setCurrentItem(selectedtab.getPosition()); //update tab position on tap
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /*
            SHOW_AS_ACTION_ALWAYS ==> Sempre Visivel
            SHOW_AS_ACTION_IF_ROOM ==> Aparece somente se estiver espaço. Quando nao há espaço vai para o menu suspenso
            SHOW_AS_ACTION_NEVER ==> Menu Suspenso
        */

        //Identificador do item, identifcador do item, ordem do item, label
        /*MenuItem m1 = menu.add(0,0,0,"Item 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

        MenuItem m2 = menu.add(0,1,1,"Item 2");
        m2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        m2.setIcon(R.mipmap.ic_launcher);

        MenuItem m3 = menu.add(0,2,2,"Item 3");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        MenuItem m4 = menu.add(0,3,3,"Item 4");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);*/

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "Logo Botao", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_location_found:
                Toast.makeText(this, "Item 1", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_refresh:
                Toast.makeText(this, "Item 2", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_help:
                Toast.makeText(this, "Item 3", Toast.LENGTH_LONG).show();
                break;

            case R.id.action_check_updates:
                Toast.makeText(this, "Item 4", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /*public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("indiceTab", getActionBar().getSelectedNavigationIndex());
    }*/
}