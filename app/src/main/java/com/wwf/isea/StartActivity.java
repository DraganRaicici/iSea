package com.wwf.isea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by dragos on 9/22/14.
 */
public class StartActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        getActionBar().hide();

        Service service= Service.getInstance();
        service.createSomeObjects();

        Button btnCamera= (Button) findViewById(R.id.btn_start_camera);
        Button btnSearch= (Button) findViewById(R.id.btn_start_search);
        Button btnMap= (Button) findViewById(R.id.btn_start_map);
        Button btnLog= (Button) findViewById(R.id.btn_start_log);
        Button btnSeaFood=(Button)findViewById(R.id.btn_food);
        Button btnAddPhoto=(Button)findViewById(R.id.btn_addPicture);
        Button btnQuiz= (Button) findViewById(R.id.btn_start_quiz);

        MyOnClickListener m1= new MyOnClickListener(this,0);
        MyOnClickListener m2= new MyOnClickListener(this,1);
        MyOnClickListener m3= new MyOnClickListener(this,2);
        MyOnClickListener m4= new MyOnClickListener(this,3);
        MyOnClickListener m5= new MyOnClickListener(this,4);
        MyOnClickListener m6= new MyOnClickListener(this,5);
        MyOnClickListener m7= new MyOnClickListener(this,6);

        btnCamera.setOnClickListener(m1);
        btnSearch.setOnClickListener(m2);
        btnMap.setOnClickListener(m3);
        btnLog.setOnClickListener(m4);
        btnSeaFood.setOnClickListener(m5);
        btnAddPhoto.setOnClickListener(m6);
        btnQuiz.setOnClickListener(m7);
    }

    private class MyOnClickListener implements View.OnClickListener{

        private int position;
        private Activity activity;
        @Override
        public void onClick(View view) {


        switch (position) {
            case 0:
            {
                Intent intentCamera = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intentCamera);
                break;
            }
            case 5:
            {
                Toast.makeText(activity, "asd", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(activity, AddPhotoActivity.class);
                startActivity(intent);

                break;
            }
            case 6:
            {

                Intent intent = new Intent(activity, PagerActivity.class);

                startActivity(intent);
                break;
            }
            default: {
                Intent intent = new Intent(activity, MainActivity.class);
                Bundle b = new Bundle();
                b.putInt(Service.POSITION, position);
                intent.putExtras(b);
                startActivity(intent);
                break;
            }
        }
    }

        public MyOnClickListener(Activity activity,int position)
        {
            this.position=position;
            this.activity=activity;
        }
    }


}
