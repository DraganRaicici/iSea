package com.wwf.isea;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by dragos on 9/22/14.
 */
public class SeaCreatureCard extends Card {

    private int mImageResourceId;
    private String mDescription;
    private String mTitle;
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
        //TextView title = (TextView) parent.findViewById(R.id.movie_card_title);
        //if (title!=null)
        //    title.setText(mTitle);

    }

    @Override
    public void setTitle(String title) {
        mTitle=title;
    }

    public void setDescription(String description){
        mDescription=description;
    }

    public void setImageView(int resourceID)
    {
        mImageResourceId=resourceID;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getImageResourceId(){

        return  mImageResourceId;
    }
}
