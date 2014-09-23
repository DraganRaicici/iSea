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
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;


/**
 * Created by rdgary on 9/22/14.
 *
 */
public class MyMapFragment extends Fragment{ // implements ClusterManager.OnClusterItemClickListener<SeaCreature>{


    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static View rootView;
    private ArrayList<SeaCreature> seaCreatures;
    private ClusterManager<SeaCreature> mClusterManager;


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


        if (rootView != null) {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null)
                parent.removeView(rootView);
        }

        // class SeaCreatureRenderer extends DefaultClusterRenderer<SeaCreature> {
          //  private final IconGenerator mIconGenerator = new IconGenerator(getActivity());
            //private final IconGenerator mClusterIconGenerator = new IconGenerator(getActivity());
           // private final ImageView mImageView;
           // private final ImageView mClusterImageView;
           // private final int mDimension;
           // public SeaCreatureRenderer() {
             //   super(getActivity(), mMap, mClusterManager);
              //  View multiProfile = getActivity().getLayoutInflater().inflate(R.layout.multi_profile,null);
               // mClusterIconGenerator.setContentView(multiProfile);
               // mClusterImageView = (ImageView) multiProfile.findViewById(R.id.image);
               // mImageView = new ImageView(getActivity());
              //  mDimension = (int) getResources().getDimension(R.dimen.custom_profile_image);
              //  mImageView.setLayoutParams(new ViewGroup.LayoutParams(mDimension, mDimension));
              //  int padding = (int) getResources().getDimension(R.dimen.custom_profile_padding);
              //  mImageView.setPadding(padding, padding, padding, padding);
               // mIconGenerator.setContentView(mImageView);
           // }
         //   @Override
           // protected void onBeforeClusterItemRendered(SeaCreature seaCreature, MarkerOptions markerOptions) {
// Draw a single person.
// Set the info window to show their name.
             //   mImageView.setImageResource(seaCreature.getImagePath());
               // Bitmap icon = mIconGenerator.makeIcon();
              //  markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon)).title(seaCreature.getName());
         //   }
         //   @Override
         //   protected void onBeforeClusterRendered(Cluster<SeaCreature> cluster, MarkerOptions markerOptions) {
// Draw multiple people.
// Note: this method runs on the UI thread. Don't spend too much time in here (like in this example).
           //     List<Drawable> profilePhotos = new ArrayList<Drawable>(Math.min(4, cluster.getSize()));
            //    int width = mDimension;
             //   int height = mDimension;
              //  for (SeaCreature s : cluster.getItems()) {
// Draw 4 at most.
                //    if (profilePhotos.size() == 4) break;
               //     Drawable drawable = getResources().getDrawable(s.getImagePath());
                  //  drawable.setBounds(0, 0, width, height);
                //    profilePhotos.add(drawable);
              //  }
           //     MultiDrawable multiDrawable = new MultiDrawable(profilePhotos);
            //    multiDrawable.setBounds(0, 0, width, height);
            //    mClusterImageView.setImageDrawable(multiDrawable);
             //   Bitmap icon = mClusterIconGenerator.makeIcon(String.valueOf(cluster.getSize()));
              //  markerOptions.icon(BitmapDescriptorFactory.fromBitmap(icon));
           // }
          //  @Override
         //   protected boolean shouldRenderAsCluster(Cluster cluster) {
// Always render clusters.
           //     return cluster.getSize() > 1;
           // }
       // }


        try {
            rootView = inflater.inflate(R.layout.fragment_map, container, false);
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            Bundle bundle=getArguments();
            longitude= bundle.getDouble(Service.LONGITUDE);
            latitude=bundle.getDouble(Service.LATITUDE);
            int zoom=10;
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), zoom));
            seaCreatures=bundle.getParcelableArrayList("array");

            mClusterManager = new ClusterManager<SeaCreature>(getActivity(),mMap);


//            for(SeaCreature s: seaCreatures){
  //              mClusterManager.addItem(s);
   //         }
            mMap.setOnCameraChangeListener(mClusterManager);
            mMap.setOnMarkerClickListener(mClusterManager);

        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }
        return rootView;
    }


    /**
     * Draws profile photos inside markers (using IconGenerator).
     * When there are multiple people in the cluster, draw multiple photos (using MultiDrawable).
     */


//    @Override
 //   public boolean onClusterItemClick(SeaCreature seaCreature) {
 //       return false;
 //   }



}
