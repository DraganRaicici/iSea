package com.wwf.isea;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by dragos on 9/30/14.
 */
public class AddPhotoActivity extends Activity {


    // this is the action code we use in our intent,
    // this way we know we're looking at the response from our own action
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addphoto);

        ImageView imgbutton= (ImageView) findViewById(R.id.img_addphoto_add);

        imgbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // in onCreate or any event where your want the user to
                // select a file
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Select Picture"), SELECT_PICTURE);
            }
        });




        FragmentManager fragmentManager= getFragmentManager();
        QuestionsFragment fragment= QuestionsFragment.newInstance(0);



        fragmentManager.beginTransaction().replace(R.id.container_addphoto,fragment)
         .commit();


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                ImageView imgbutton= (ImageView) findViewById(R.id.img_addphoto_userphoto);
                imgbutton.setImageURI(selectedImageUri);
            }
        }
    }




    public void changeFragment(int position)
    {

        FragmentManager fragmentManager= getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_addphoto, QuestionsFragment.newInstance(position+1))
                .commit();


    }
}
