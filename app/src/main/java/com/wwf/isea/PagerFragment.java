package com.wwf.isea;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dragos on 9/23/14.
 */
public class PagerFragment extends Fragment {
    int position=0;
    String question;
    String answer1;
    String answer2;

    // Container Activity must implement this interface
    public interface OnNextPageListener {
        public void onNextPageSelected(int position);
    }

    // define listener in fragment
    OnNextPageListener mNextPageListener;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.fragment_main, container, false);

            TextView q=(TextView) rootView.findViewById(R.id.quiz_text_question);
            TextView s1=(TextView) rootView.findViewById(R.id.quiz_text_ans1);
            TextView s2=(TextView) rootView.findViewById(R.id.quiz_text_ans2);

            q.setText(question);
            s1.setText(answer1);
            s2.setText(answer2);

            if(position%2==0)
            s1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mNextPageListener.onNextPageSelected(position);
                }
            });
            s2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mNextPageListener.onNextPageSelected(position);
                }
            });
            return rootView;
        }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mNextPageListener = (OnNextPageListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnNextPageListener");
        }




    }
    public void setQuestions(int position)
    {
        this.position=position;
        switch (position)
        {
            case 0:
            {
                question="Is it a fish?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
            case 1:
            {

                question="Is it a fish?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
            case 2:
            {

                question="Is it a fish?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
            case 3:
            {

                question="Is it a fish?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
            case 4:
            {

                question="Is it a fish?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
        }
    }

}
