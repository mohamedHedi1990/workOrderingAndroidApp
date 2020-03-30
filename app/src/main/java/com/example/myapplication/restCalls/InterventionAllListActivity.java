package com.example.myapplication.restCalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.myapplication.R;

public class InterventionAllListActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventionalllist);
        mListView = (ListView) findViewById(R.id.interventionAlllistitems);

        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),MainDashbordAdminActivity.class);
                v.getContext().startActivity(intent);


            }
        });


        InterventionRestCall.getAllInterventions( mListView, this  );



    }


}
