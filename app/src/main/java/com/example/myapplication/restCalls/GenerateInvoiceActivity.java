package com.example.myapplication.restCalls;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication.R;

public class GenerateInvoiceActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facturedescription);
        final Intervention intervention = new Intervention();

        Intent myIntent = getIntent();
        System.out.println("hhhhhh  "+myIntent.getStringExtra("id"));
        intervention.setId(Integer.parseInt(myIntent.getStringExtra("id")));
        intervention.setTitle(myIntent.getStringExtra("title"));
        intervention.setDescription(myIntent.getStringExtra("description"));
        intervention.setClient(myIntent.getStringExtra("client"));
        intervention.setStatus(myIntent.getStringExtra("status"));
        intervention.setType(myIntent.getStringExtra("type"));

       final  TextView tasksDone = (TextView) findViewById(R.id.tasksDoneText);
       final TextView tasksNotDone = (TextView) findViewById(R.id.tasksNotDoneText);
        final TextView cost = (TextView) findViewById(R.id.costText);


        //invoice.setIntervention(intervention);



        Button sendInvoiceButton = (Button) findViewById(R.id.sendInvoiceButton);


        sendInvoiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Invoice invoice =new Invoice();
                invoice.setCost(cost.getText().toString());
                System.out.println("cost--------------------- "+invoice.getCost());
                invoice.setTasksDone(tasksDone.getText().toString());
                invoice.setTasksNotDone(tasksNotDone.getText().toString());

                InterventionRestCall.saveInvoice(invoice,intervention);

                Intent intent = new Intent(v.getContext(),InterventionListActivity.class);
                v.getContext().startActivity(intent);


            }
        });



    }


}
