package com.example.myapplication.restCalls;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.views.InterventionAdapter;
import com.example.myapplication.views.ViewMethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InterventionCreateActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interventioncreate);
        Button returnButton = (Button) findViewById(R.id.returnButton);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(v.getContext(),MainDashbordClientActivity.class);
                v.getContext().startActivity(intent);


            }
        });

         final EditText title = (EditText) findViewById(R.id.intervTitleText_create);
       final  EditText description = (EditText) findViewById(R.id.intervDescriptionText_create);
       final  EditText client = (EditText) findViewById(R.id.intervClientText_create);
      final  EditText type = (EditText) findViewById(R.id.intervTypeText_create);
        final EditText dateIntervention = (EditText) findViewById(R.id.intervDateText_create);
client.setText(UserRestCall.clientUser);
client.setEnabled(false);

final TextView userName = (TextView) findViewById(R.id.userName) ;
userName.setTextColor(Color.parseColor("#DC143C"));
        userName.setText(UserRestCall.connectedUser_login);

        final TextView disconnect = (TextView) findViewById(R.id.disconnect) ;
        disconnect.setTextColor(Color.parseColor("#0000FF"));

        disconnect.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                v.getContext().startActivity(intent);
            }
        });


        dateIntervention.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                // To show current date in the datepicker
                Calendar mcurrentDate = Calendar.getInstance();
              int  mYear = mcurrentDate.get(Calendar.YEAR);
               int mMonth = mcurrentDate.get(Calendar.MONTH);
                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        String myFormat = "yyyy-MM-dd"; //Change as you need
                        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.FRANCE);
                        dateIntervention.setText(sdf.format(myCalendar.getTime()));

                        int mDay = selectedday;
                        int mMonth = selectedmonth;
                        int mYear = selectedyear;
                    }
                }, mYear, mMonth, mDay);
                //mDatePicker.setTitle("Select date");
                mDatePicker.show();
            }
        });
        Button submit = (Button) findViewById(R.id.submit);
        final InterventionCreateActivity thisActivity= this;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intervention intervention = new Intervention();
                intervention.setTitle(title.getText().toString());
                intervention.setDescription(description.getText().toString());
                intervention.setClient(client.getText().toString());
                intervention.setType(type.getText().toString());
                intervention.setDateIntervention(dateIntervention.getText().toString());

                UserRestCall.saveIntervention(thisActivity,v,intervention);




            }
        });


    }



}
