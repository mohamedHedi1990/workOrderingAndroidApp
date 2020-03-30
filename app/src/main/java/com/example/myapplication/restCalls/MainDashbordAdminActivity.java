package com.example.myapplication.restCalls;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import android.view.View;
public class MainDashbordAdminActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maindashbordadmin);

        final TextView userName = (TextView) findViewById(R.id.userNamedashbordadmin) ;
        userName.setTextColor(Color.parseColor("#DC143C"));
        userName.setText(UserRestCall.connectedUser_login);

        final TextView disconnect = (TextView) findViewById(R.id.disconnectadmin) ;
        disconnect.setTextColor(Color.parseColor("#0000FF"));
disconnect.setOnClickListener(new View.OnClickListener(){
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        v.getContext().startActivity(intent);
    }
});
        ImageView addUserImage = (ImageView) findViewById(R.id.adduserimage) ;
        ImageView addTaskImage = (ImageView) findViewById(R.id.addtaskimage) ;
        ImageView listUsersImage = (ImageView) findViewById(R.id.listuserimage) ;
        ImageView listInterventionsImage = (ImageView) findViewById(R.id.listtaskimage) ;
        listInterventionsImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               Intent intent = new Intent(v.getContext(),InterventionAllListActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        addTaskImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),InterventionCreateActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        addUserImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),CreateUserActivity.class);
                v.getContext().startActivity(intent);
            }
        });

    }


}
