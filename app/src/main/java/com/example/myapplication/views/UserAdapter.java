package com.example.myapplication.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.myapplication.R;
import com.example.myapplication.restCalls.Intervention;
import com.example.myapplication.restCalls.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public final static String NOT_AFFECTED = "NOT_AFFECTED";
    public final static String AFFECTED = "AFFECTED";
    public final static String IN_PROGRESS = "IN_PROGRESS";
    public final static String FINISHED = "FINISHED";
    public final static String VALIDATED = "VALIDATED";
    public UserAdapter(Context context, List<User> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_user,parent, false);
        }

        UserViewHolder viewHolder = (UserViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new UserViewHolder();
            viewHolder.fullName = (TextView) convertView.findViewById(R.id.fullName);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
       User user = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.fullName.setText(user.getFirstName()+" "+ user.getLastName());
        //viewHolder.description.setText(intervention.getDescription());
        viewHolder.avatar.setImageResource(R.drawable.profil);

        return convertView;
    }

    private class UserViewHolder{
        public TextView fullName;
        public ImageView avatar;

    }
}
