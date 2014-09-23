package com.wwf.isea;

import android.app.Activity;
import android.app.Dialog;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dragos on 9/23/14.
 */
public class PagerFragment extends Fragment {
    int position=0;
    String question;
    String answer1;
    String answer2;
    boolean isFinished=false;

    // Container Activity must implement this interface
    public interface OnNextPageListener {
        public void onNextPageSelected(int position,boolean isNext);
    }

    // define listener in fragment
    OnNextPageListener mNextPageListener;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            ViewGroup rootView = (ViewGroup) inflater.inflate(
                    R.layout.fragment_main, container, false);


            TextView q=(TextView) rootView.findViewById(R.id.quiz_text_question);
            final RadioButton s1=(RadioButton) rootView.findViewById(R.id.quiz_text_ans1);
            RadioButton s2=(RadioButton) rootView.findViewById(R.id.quiz_text_ans2);
            Button btn_Next =(Button)rootView.findViewById(R.id.next_button);
            Button btn_Previous =(Button)rootView.findViewById(R.id.prev_button);

            q.setText(question);
            s1.setText(answer1);
            s2.setText(answer2);


            if (position==5) {
                s1.setVisibility(View.INVISIBLE);
                q.setVisibility(View.INVISIBLE);
                s2.setVisibility(View.INVISIBLE);

                btn_Next.setVisibility(View.INVISIBLE);
                btn_Previous.setVisibility(View.INVISIBLE);
                ImageView img=(ImageView) rootView.findViewById(R.id.quiz_img);
                img.setImageResource(R.drawable.cucumber);
                final Activity activity=getActivity();
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        activity.finish();
                    }
                });

            }
            btn_Next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (s1.isChecked()) {
                        mNextPageListener.onNextPageSelected(position, true);
                    }else{
                        Toast.makeText(getActivity(), "Look again at the picture",
                                Toast.LENGTH_LONG).show();
                    }

                }
            });
            btn_Previous.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mNextPageListener.onNextPageSelected(position, false);
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

                question="Does it have spots?"+position;
                answer1="Yes";
                answer2="No";
                break;
            }
            case 2:
            {

                question="It lives in salt water?"+position;
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
            case 5: {
                question = "Is it a fish?" + position;
                answer1 = "Yes";
                answer2 = "No";
                break;
            }



        }
    }

}
