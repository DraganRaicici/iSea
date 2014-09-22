package com.wwf.isea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by dragos on 9/22/14.
 */
public class StartActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        Button btnCamera= (Button) findViewById(R.id.btn_start_camera);
        Button btnSearch= (Button) findViewById(R.id.btn_start_search);
        Button btnMap= (Button) findViewById(R.id.btn_start_map);
        Button btnLog= (Button) findViewById(R.id.btn_start_log);
        Button btnQuiz= (Button) findViewById(R.id.btn_start_quiz);

        MyOnClickListener m1= new MyOnClickListener(this,1);
        MyOnClickListener m2= new MyOnClickListener(this,2);
        MyOnClickListener m3= new MyOnClickListener(this,3);
        MyOnClickListener m4= new MyOnClickListener(this,4);
        MyOnClickListener m5= new MyOnClickListener(this,5);

        btnCamera.setOnClickListener(m1);
        btnSearch.setOnClickListener(m2);
        btnMap.setOnClickListener(m3);
        btnLog.setOnClickListener(m4);
        btnQuiz.setOnClickListener(m5);
    }

    private class MyOnClickListener implements View.OnClickListener{

        private int position;
        private Activity activity;
        @Override
        public void onClick(View view) {

            Intent intent= new Intent(activity,MainActivity.class);
            intent.putExtra("position",position);
            startActivity(intent);
        }

        public MyOnClickListener(Activity activity,int position)
        {
            this.position=position;
            this.activity=activity;
        }
    }


}
