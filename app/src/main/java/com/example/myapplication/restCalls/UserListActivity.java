package com.example.myapplication.restCalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import com.example.myapplication.R;

public class UserListActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.useralllist);
        mListView = (ListView) findViewById(R.id.userAlllistitems);

        Intent myIntent = getIntent();
        System.out.println("hhhhhh  "+myIntent.getStringExtra("id"));
       Integer id =Integer.parseInt(myIntent.getStringExtra("id"));
        String title =(myIntent.getStringExtra("title"));

        InterventionRestCall.getAllUsers( mListView, this , id, title);





    }


}
