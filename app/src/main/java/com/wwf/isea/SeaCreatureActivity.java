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
        SeaCreature seaCreature= bundle.getParcelable(Service.SEACREATURE);

        ImageView imgView=(ImageView) findViewById(R.id.sea_activity_image);
        TextView nameView=(TextView) findViewById(R.id.sea_activity_name);
        TextView descriptionView=(TextView) findViewById(R.id.sea_description);

        descriptionView.setText(seaCreature.getDescription());
        nameView.setText(seaCreature.getName());
        imgView.setImageResource(seaCreature.getImagePath());


    }


}
