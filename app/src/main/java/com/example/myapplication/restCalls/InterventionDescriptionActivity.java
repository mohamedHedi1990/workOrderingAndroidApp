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

public class InterventionDescriptionActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventiondescription);
        final Intervention intervention = new Intervention();

        Intent myIntent = getIntent();
        System.out.println("hhhhhh  "+myIntent.getStringExtra("id"));
        intervention.setId(Integer.parseInt(myIntent.getStringExtra("id")));
        intervention.setTitle(myIntent.getStringExtra("title"));
        intervention.setDescription(myIntent.getStringExtra("description"));
        intervention.setClient(myIntent.getStringExtra("client"));
        intervention.setStatus(myIntent.getStringExtra("status"));
        intervention.setType(myIntent.getStringExtra("type"));
        intervention.setDateIntervention(myIntent.getStringExtra("dateIntervention"));
        TextView title = (TextView) findViewById(R.id.intervTitleText);
        title.setEnabled(false);
        TextView description = (TextView) findViewById(R.id.intervDescriptionText);
        description.setEnabled(false);
        TextView client = (TextView) findViewById(R.id.intervClientText);
        client.setEnabled(false);
        TextView user = (TextView) findViewById(R.id.intervClientText);
        client.setEnabled(false);
        final TextView status = (TextView) findViewById(R.id.intervStatusText);
        status.setEnabled(false);
        TextView type = (TextView) findViewById(R.id.intervTypeText);
        type.setEnabled(false);
TextView dateInterv = (TextView) findViewById(R.id.intervDateText) ;
dateInterv.setEnabled(false);


        ViewMethods.setInterventionParameters(intervention,title,description,client,status,type, dateInterv);

        Button inprogressButton = (Button) findViewById(R.id.progressButton);
        //Button validateButton = (Button) findViewById(R.id.validateButton);
        Button finishButton = (Button) findViewById(R.id.finishButton);
        Button generateInvoice = (Button) findViewById(R.id.generateInvoiceButton);
       // if(!intervention.getStatus().equals(InterventionAdapter.VALIDATED))
           // generateInvoice.setEnabled(false);
        generateInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(),GenerateInvoiceActivity.class);
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

        inprogressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status.setText(InterventionAdapter.IN_PROGRESS);

                InterventionRestCall.inProgressIntervention(intervention.getId());


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

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                status.setText(InterventionAdapter.FINISHED);

                InterventionRestCall.finishIntervention(intervention.getId());


            }
        });


    }


}
