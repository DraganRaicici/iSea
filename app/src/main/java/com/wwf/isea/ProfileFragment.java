package com.wwf.isea;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.gmariotti.cardslib.library.extra.staggeredgrid.internal.CardGridStaggeredArrayAdapter;
import it.gmariotti.cardslib.library.extra.staggeredgrid.view.CardGridStaggeredView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by paula on 9/22/14.
 */
public class ProfileFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";
    Service service = Service.getInstance();

    public static ProfileFragment newInstance(int sectionNumber) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile, container,
                false);



        String userName = "Steve Jobs";

        String email = "SteveJobs@apple.com";
        String citi = "Sillicon Valey ";
        int rating = 3;

        TextView name = (TextView) rootView.findViewById(R.id.textViewName);
        TextView emaill = (TextView) rootView.findViewById(R.id.textViewEmail);
        TextView city = (TextView) rootView.findViewById(R.id.textViewCity);
        RatingBar ratingbar = (RatingBar) rootView.findViewById(R.id.ratingBar);
        ListView listUserFish = (ListView) rootView
                .findViewById(R.id.listView1);

       // CardListView cListView= new CardListView(getActivity());
        ArrayList<Card> cards= getCards();
        CardGridStaggeredArrayAdapter cAdapter= new CardGridStaggeredArrayAdapter(getActivity(),cards);
        listUserFish.setAdapter(cAdapter);


        name.setText(userName);
        emaill.setText(email);
        city.setText(citi);
        ratingbar.setNumStars(rating);

        return rootView;




    }
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }
    private ArrayList<Card> getCards() {
        ArrayList<Card> cards= new ArrayList<Card>();
        Service service=Service.getInstance();

        List<SeaCreature> seaCreatures= service.getSeaCreaturesForSpecificUser();

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
