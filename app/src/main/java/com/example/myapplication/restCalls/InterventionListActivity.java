package com.example.myapplication.restCalls;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.example.myapplication.R;

public class InterventionListActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventionlist);
        Button returnButton = (Button)  findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),MainDashbordClientActivity.class);
                v.getContext().startActivity(intent);


            }
        });
        mListView = (ListView) findViewById(R.id.interventionlistitems);

        if(UserRestCall.isClient==true)
        {
            InterventionRestCall.getAllInterventionsForCurrentClient( mListView, this , UserRestCall.clientUser );
        }
        if(UserRestCall.isAdmin==true)
        {
            InterventionRestCall.getAllInterventionsForCurrentUser( mListView, this , UserRestCall.connectedIdUser );
        }






    }


}
