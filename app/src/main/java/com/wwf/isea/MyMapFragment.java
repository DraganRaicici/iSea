package com.wwf.isea;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


/**
 * Created by rdgary on 9/22/14.
 *
 */
public class MyMapFragment extends Fragment {


    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static View rootView;


    public static MyMapFragment newInstance(int sectionNumber) {
        MyMapFragment fragment = new MyMapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public MyMapFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


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
            Log.v("aaa",longitude+" "+latitude+"");
            int zoom=10;
            //mMap.moveCamera(CameraUpdateFactory.);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), zoom));

            LatLng myPosition= new LatLng(latitude,longitude);
            mMap.addMarker(new MarkerOptions()
                    .position(myPosition)
                    .title("You"));

            final ArrayList<SeaCreature> seaCreatures=bundle.getParcelableArrayList("array");

            ArrayList<Marker> markers= new ArrayList<Marker>();

            for(SeaCreature s: seaCreatures){
                LatLng position=s.getPosition();

                Bitmap bmp=decodeSampledBitmapFromResource(getResources(), s.getImagePath(), 20, 20);

                BitmapDescriptor icon =BitmapDescriptorFactory.fromBitmap(bmp);
                Marker m= mMap.addMarker(new MarkerOptions()
                        .position(position)
                        .title(s.getName())
                        .snippet("See More")
                        .icon(icon));

            }

            GoogleMap.OnInfoWindowClickListener listener= new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    String name=marker.getTitle();
                    for(SeaCreature s:seaCreatures){
                        if(s.getName().equals(name))
                        {

                            Intent i = new Intent(getActivity(), SeaCreatureActivity.class);
                            Bundle bundle = new Bundle();

                            bundle.putParcelable(Service.SEACREATURE,s);
                            i.putExtras(bundle);
                            getActivity().startActivity(i);
                        }
                    }
                }
            };
              mMap. setOnInfoWindowClickListener(listener);

        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        return rootView;
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight
                    && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }
    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }


}