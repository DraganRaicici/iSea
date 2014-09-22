package com.wwf.isea;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;




/**
 * Created by rdgary on 9/22/14.
 * hello
 */
public class MyMapFragment extends Fragment{


   // private GoogleMap map;
    private static final String ARG_SECTION_NUMBER = "section_number";

    public static MyMapFragment newInstance(int sectionNumber) {
        MyMapFragment fragment = new MyMapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MyMapFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
             //   .getMap();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

}
