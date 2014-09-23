package com.wwf.isea;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreatureCard extends Card {


    private SeaCreature seaCreature;
    public SeaCreatureCard(Context context) {
        super(context);
    }

    public SeaCreatureCard(Context context, int innerLayout) {
        super(context, innerLayout);init();
    }

    public void init(){

        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {

                //DAO dao=DAO.getInstance();


                Intent i = new Intent(mContext, SeaCreatureActivity.class);
                Bundle bundle = new Bundle();

                bundle.putParcelable(Service.SEACREATURE,seaCreature);
                i.putExtras(bundle);
                mContext.startActivity(i);
            }
        });

    }

    @Override
    public void setupInnerViewElements(ViewGroup parent, View view) {
        //Retrieve elements
        TextView name = (TextView) parent.findViewById(R.id.sea_card_name);
        TextView description = (TextView) parent.findViewById(R.id.sea_card_description);
        ImageView imageView = (ImageView) parent.findViewById(R.id.sea_card_image);

        if (name!=null) {
            name.setText(seaCreature.getName());

        }
        if (description!=null)
            description.setText(seaCreature.getDescription());

        if (imageView!=null) {
            imageView.setImageResource(seaCreature.getImagePath());
        }
    }


    public void setName(String name) {
        seaCreature.setName(name);
    }

    public void setDescription(String description){
        seaCreature.setDescription(description);
    }

    public void setImageView(int resourceID)
    {
        seaCreature.setImagePath(resourceID);
    }


    public String getName() {
        return seaCreature.getName();
    }

    public String getDescription() {
        return seaCreature.getDescription();
    }

    public int getImageResourceId(){

        return  seaCreature.getImagePath();
    }

    public SeaCreature getSeaCreature() {
        return seaCreature;
    }

    public void setSeaCreature(SeaCreature seaCreature) {
        this.seaCreature = seaCreature;
    }
}
