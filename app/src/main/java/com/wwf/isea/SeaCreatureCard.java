package com.wwf.isea;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreatureCard extends Card {

    private int mImageResourceId;
    private String mDescription;
    private String mName;
    public SeaCreatureCard(Context context) {
        super(context);
    }

    public SeaCreatureCard(Context context, int innerLayout) {
        super(context, innerLayout);
    }

    public void init(){

        setOnClickListener(new OnCardClickListener() {
            @Override
            public void onClick(Card card, View view) {

                //DAO dao=DAO.getInstance();

                Toast t=Toast.makeText(getContext(), "sadsadas.",Toast.LENGTH_SHORT);
                t.show();
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
            name.setText(mName);
            Log.w("bbb", mName);
        }
        if (description!=null)
            description.setText(mDescription);

        if (imageView!=null)
            imageView.setImageResource(mImageResourceId);
    }


    public void setName(String name) {
        this.mName=name;
    }

    public void setDescription(String description){
        mDescription=description;
    }

    public void setImageView(int resourceID)
    {
        mImageResourceId=resourceID;
    }


    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId(){

        return  mImageResourceId;
    }
}
