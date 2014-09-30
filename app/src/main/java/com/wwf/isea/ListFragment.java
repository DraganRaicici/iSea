package com.wwf.isea;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.extra.staggeredgrid.internal.CardGridStaggeredArrayAdapter;
import it.gmariotti.cardslib.library.extra.staggeredgrid.view.CardGridStaggeredView;
import it.gmariotti.cardslib.library.internal.Card;

/**
 * Created by dragos on 9/22/14.
 */
public class ListFragment extends Fragment {



        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        private Boolean searched=false;
        private String mQuery="";
       // private int sectionNumber;
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ListFragment newInstance(int sectionNumber) {
            ListFragment fragment = new ListFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public ListFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            //View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            CardGridStaggeredView cListView= new CardGridStaggeredView(getActivity());
            ArrayList<Card> cards=null;
            Bundle b=getArguments();

            if(b.getInt(ARG_SECTION_NUMBER)==2){
                cards=getCards();
            }
             else if(b.getInt(ARG_SECTION_NUMBER)==5){
                cards=getSeaFoodCards();
            }

            else if(b.getInt(ARG_SECTION_NUMBER)==2 && searched==true) {
                cards = getSearchedCards();
            }
            else {

                cards= getCards();
            }
            CardGridStaggeredArrayAdapter cAdapter= new CardGridStaggeredArrayAdapter(getActivity(),cards);
            cListView.setAdapter(cAdapter);
            return cListView;
           
        }

    public void setQuery(String query) {
        searched=true;
        mQuery=query;
    }
    private ArrayList<Card> getSearchedCards() {
        ArrayList<Card> cards= new ArrayList<Card>();

        Service service =Service.getInstance();
        ArrayList<SeaCreature> seaCreatures=service.getSeaCreatures();
        for(SeaCreature s:seaCreatures)
        {
            String name=s.getName();
            if(mQuery.length()<=name.length())
            {
                String s1=mQuery.toLowerCase().substring(0);
                String s2=name.toLowerCase().substring(0,mQuery.length());

                if(s1.equals(s2))
                {

                    SeaCreatureCard sCard= new SeaCreatureCard(getActivity(),R.layout.card_seacreature);
                    sCard.setSeaCreature(s);

                    cards.add(sCard);
                }
            }
        }
        return cards;
    }

    private ArrayList<Card> getSeaFoodCards() {
        ArrayList<Card> cards= new ArrayList<Card>();
        Service service=Service.getInstance();

        List<SeaCreature> seaCreatures= service.getSeaFood();

        for(SeaCreature s: seaCreatures){
            SeaCreatureCard sCard= new SeaCreatureCard(getActivity(),R.layout.card_seacreature);
            sCard.setSeaCreature(s);

            cards.add(sCard);
        }

        return cards;
    }
    private ArrayList<Card> getCards() {
        ArrayList<Card> cards= new ArrayList<Card>();
        Service service=Service.getInstance();

        ArrayList<SeaCreature> seaCreatures= service.getSeaCreatures();

        for(SeaCreature s: seaCreatures){
            SeaCreatureCard sCard= new SeaCreatureCard(getActivity(),R.layout.card_seacreature);
            sCard.setSeaCreature(s);

            cards.add(sCard);
        }

        return cards;
    }



    @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }



}

