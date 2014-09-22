package com.wwf.isea;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;


/**
 * Created by rdgary on 9/22/14.
 *
 */
public class MyMapFragment extends Fragment{


    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static View rootView;

    public static MyMapFragment newInstance(int sectionNumber) {
        MyMapFragment fragment = new MyMapFragment();
       // Bundle args = new Bundle();
       // args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        //fragment.setArguments(args);
        return fragment;
    }

    public MyMapFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View rootView; inflater.inflate(R.layout.fragment_map, container, false);

        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
                parent.removeView(rootView);
        }
        try {
            rootView = inflater.inflate(R.layout.fragment_map, container, false);
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            Bundle bundle=getArguments();
            longitude= bundle.getDouble(Service.LONGITUDE);
            latitude=bundle.getDouble(Service.LATITUDE);
           // Log.v("aaaaaaaa", longitude + "-");
            int zoom=10;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), zoom));



        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        return rootView;
    }
}
