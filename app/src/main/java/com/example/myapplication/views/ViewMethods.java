package com.example.myapplication.views;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.restCalls.Intervention;
import com.example.myapplication.restCalls.UserRestCall;

public class ViewMethods {

    public  static void login(Button loginButton, final EditText login, final EditText password)
    {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = login.getText().toString();
                String pass = password.getText().toString();

                UserRestCall.getUser(userName,pass, v);


            }
        });
    }

    public static void setInterventionParametersAdmin(Intervention intervention, TextView title, TextView desc, TextView client, TextView status, TextView type, TextView dateInterv, TextView user, String username ) {
        title.setText(intervention.getTitle());
        desc.setText(intervention.getDescription());
        client.setText(intervention.getClient());
        status.setText(intervention.getStatus());
        type.setText(intervention.getType());
        dateInterv.setText(intervention.getDateIntervention());

            user.setText(username);

    }

    public static void setInterventionParameters(Intervention intervention, TextView title, TextView desc, TextView client, TextView status, TextView type, TextView dateInterv ) {
        title.setText(intervention.getTitle());
        desc.setText(intervention.getDescription());
        client.setText(intervention.getClient());
        status.setText(intervention.getStatus());
        type.setText(intervention.getType());
        dateInterv.setText(intervention.getDateIntervention());

    }
}
