package com.wwf.isea;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

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
            ArrayList<Card> cards= getCards();
            CardGridStaggeredArrayAdapter cAdapter= new CardGridStaggeredArrayAdapter(getActivity(),cards);
            cListView.setAdapter(cAdapter);
            return cListView;
           
        }

    private ArrayList<Card> getCards() {
        ArrayList<Card> cards= new ArrayList<Card>();
        Service service=Service.getInstance();

        ArrayList<SeaCreature> seaCreatures= service.getSeaCreatures();

        for(SeaCreature s: seaCreatures){
            SeaCreatureCard sCard= new SeaCreatureCard(getActivity(),R.layout.card_seacreature);
            sCard.setName(s.getName());
            sCard.setDescription(s.getDescription());
            //TODO Image make setImageView to get String not int
            //sCard.setImageView(s.getImagePath());
            sCard.setImageView(R.drawable.nemo);

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

