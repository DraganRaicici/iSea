package com.wwf.isea;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreatureActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seacreature);

        Bundle bundle= getIntent().getExtras();
        final SeaCreature seaCreature= bundle.getParcelable(Service.SEACREATURE);

        ImageView imgView=(ImageView) findViewById(R.id.sea_activity_image);
        TextView nameView=(TextView) findViewById(R.id.sea_activity_name);
        TextView descriptionView=(TextView) findViewById(R.id.sea_description);
       // Button btnGo=(Button) findViewById(R.id.btnGo);





       /* imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<SeaCreature> s=new ArrayList<SeaCreature>();

                s.add(seaCreature);
                seaCreature.setLat(55.6915199);
                seaCreature.setLng(10.8970642);
                s.add(seaCreature);
                seaCreature.setLat(55.6078327);
                seaCreature.setLng(10.0675964);
                s.add(seaCreature);
                seaCreature.setLat(55.6636440);
                seaCreature.setLng(9.8753357);
                Fragment mapFragment = MyMapFragment.newInstance(1);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("arrayList",s);
                mapFragment.setArguments(bundle);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, mapFragment)
                        .commit();

            }
        });
        */

        descriptionView.setText(seaCreature.getDescription());
        nameView.setText(seaCreature.getName());
        imgView.setImageResource(seaCreature.getImagePath());


    }



}
