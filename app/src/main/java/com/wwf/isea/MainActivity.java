package com.wwf.isea;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private MyLocation myLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        //TODO set right position on start
        Bundle bundle=getIntent().getExtras();
        int position= bundle.getInt(Service.POSITION);
        onNavigationDrawerItemSelected(position);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        switch (position)
        {
            case 2:


                Fragment mapFragment=MyMapFragment.newInstance(position + 1);
                Bundle bundle = new Bundle();
                myLocation=new MyLocation(MainActivity.this);
                Log.d("In MainActivity",myLocation.getLongitude()+"");
                bundle.putDouble(Service.LONGITUDE,myLocation.getLongitude());
                bundle.putDouble(Service.LATITUDE,myLocation.getLatitude());
                mapFragment.setArguments(bundle);

            fragmentManager.beginTransaction()
                    .replace(R.id.container, mapFragment)
                    .commit();


            break;
            case 3:
                fragmentManager.beginTransaction().replace(R.id.container,ProfileFragment.newInstance(position +1))
                        .commit();
                break;
        default:
        fragmentManager.beginTransaction()
                .replace(R.id.container, ListFragment.newInstance(position + 1))
                .commit();
    }}

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.drawer_1_camera);
                break;
            case 2:
                mTitle = getString(R.string.drawer_2_search);
                break;
            case 3:
                mTitle = getString(R.string.drawer_3_map);
                break;
            case 4:
                mTitle = getString(R.string.drawer_4_log);
                break;
            case 5:
                mTitle = getString(R.string.action_Food);
                break;
            case 6 :

                mTitle = getString(R.string.action_addPhoto);
                break;
            case 7:

                mTitle = getString(R.string.drawer_5_quiz);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
