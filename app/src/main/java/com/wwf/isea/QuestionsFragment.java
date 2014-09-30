package com.wwf.isea;

import android.app.Activity;
import android.app.Fragment;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by dragos on 9/30/14.
 */
public class QuestionsFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    Service service = Service.getInstance();

    public static QuestionsFragment newInstance(int sectionNumber) {
        QuestionsFragment fragment = new QuestionsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public QuestionsFragment() {
    }

    private ArrayList<String> answers;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addphoto, container,
                false);

        Bundle args = getArguments();
        int p = args.getInt(ARG_SECTION_NUMBER);

        String[] a={"ballan", "jelly", "mollusc", "nemo", "worm"};
        a[0]="item clicked at:"+p;




        // fill list with Q&A
        ListView listView = (ListView) rootView.findViewById(R.id.listview_addphoto);
        Integer[] pics = {R.drawable.ballan, R.drawable.jellyfish, R.drawable.mollusc, R.drawable.nemo, R.drawable.worm};

        CustomList adapter = new CustomList(getActivity(), a, pics);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                AddPhotoActivity ac = (AddPhotoActivity) getActivity();
                ac.changeFragment(position);
            }
        });

        return rootView;
    }


    private class CustomList extends ArrayAdapter<String> {
        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;

        public CustomList(Activity context,
                          String[] web, Integer[] imageId) {
            super(context, R.layout.list_single, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.list_single, null, true);
            TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
            txtTitle.setText(web[position]);
            imageView.setImageResource(imageId[position]);
            return rowView;
        }


    }
}
