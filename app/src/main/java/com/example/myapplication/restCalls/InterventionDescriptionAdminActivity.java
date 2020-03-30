package com.example.myapplication.restCalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.views.InterventionAdapter;
import com.example.myapplication.views.ViewMethods;

public class InterventionDescriptionAdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventiondescriptionadmin);
        final Intervention intervention = new Intervention();
        Button returnButton = (Button) findViewById(R.id.returnButtonDescriptionAdmin);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),MainDashbordAdminActivity.class);
                v.getContext().startActivity(intent);


            }
        });
        Intent myIntent = getIntent();
        System.out.println("hhhhhh  "+myIntent.getStringExtra("id"));
        intervention.setId(Integer.parseInt(myIntent.getStringExtra("id")));
        intervention.setTitle(myIntent.getStringExtra("title"));
        intervention.setDescription(myIntent.getStringExtra("description"));
        intervention.setClient(myIntent.getStringExtra("client"));
        intervention.setStatus(myIntent.getStringExtra("status"));
        intervention.setType(myIntent.getStringExtra("type"));
        intervention.setDateIntervention(myIntent.getStringExtra("dateIntervention"));
        String userName=myIntent.getStringExtra("user");
        intervention.setFullUserName(userName);
        TextView title = (TextView) findViewById(R.id.intervTitleText);
        title.setEnabled(false);
        TextView description = (TextView) findViewById(R.id.intervDescriptionText);
        description.setEnabled(false);
        TextView client = (TextView) findViewById(R.id.intervClientText);
        client.setEnabled(false);
        final TextView status = (TextView) findViewById(R.id.intervStatusText);
        status.setEnabled(false);
        TextView type = (TextView) findViewById(R.id.intervTypeText);
        type.setEnabled(false);
TextView dateInterv = (TextView) findViewById(R.id.intervDateText) ;
dateInterv.setEnabled(false);
        TextView user = (TextView) findViewById(R.id.intervUserText);
        type.setEnabled(false);


        ViewMethods.setInterventionParametersAdmin(intervention,title,description,client,status,type, dateInterv, user, userName);

        Button affectButton = (Button) findViewById(R.id.affect);
//if(!intervention.getStatus().equals(InterventionAdapter.NOT_AFFECTED))
//affectButton.setEnabled(false);
        affectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),UserListActivity.class);
                intent.putExtra("title", intervention.getTitle());
                intent.putExtra("type", intervention.getType());
                intent.putExtra("client", intervention.getClient());
                intent.putExtra("description", intervention.getDescription());
                intent.putExtra("status", intervention.getStatus());
                System.out.println("-------------------- "+intervention.getId());
                intent.putExtra("id",""+intervention.getId());
                v.getContext().startActivity(intent);




            }
        });



        /*validateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status.setText(InterventionAdapter.VALIDATED);
                System.out.println("idd  "+intervention.getId());

                InterventionRestCall.validateIntervention(intervention.getId());


            }
        });*/




    }


}
