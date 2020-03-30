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

import java.util.List;

public class InterventionAdapter extends ArrayAdapter<Intervention> {

    public final static String NOT_ASSIGNED = "NOT_ASSIGNED";
    public final static String ASSIGNED = "ASSIGNED";
    public final static String IN_PROGRESS = "IN_PROGRESS";
    public final static String FINISHED = "FINISHED";
    public final static String VALIDATED = "VALIDATED";
    public InterventionAdapter(Context context, List<Intervention> interventions) {
        super(context, 0, interventions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_intervention,parent, false);
        }

        InerventionViewHolder viewHolder = (InerventionViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new InerventionViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
           // viewHolder.description = (TextView) convertView.findViewById(R.id.description);
            viewHolder.client = (TextView) convertView.findViewById(R.id.client);
            viewHolder.type = (TextView) convertView.findViewById(R.id.type);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Intervention intervention = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.title.setText(intervention.getTitle());
        //viewHolder.description.setText(intervention.getDescription());
        viewHolder.type.setText(intervention.getType());
        viewHolder.status.setText(intervention.getStatus());
        viewHolder.client.setText(intervention.getClient());
        if(intervention.getStatus().equals(NOT_ASSIGNED))
            viewHolder.avatar.setImageResource(R.drawable.nassigned);
            // viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.GRAY));
        else if (intervention.getStatus().equals(IN_PROGRESS))
            viewHolder.avatar.setImageResource(R.drawable.inprogress);
            //viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.CYAN));
        else if (intervention.getStatus().equals(VALIDATED))
            viewHolder.avatar.setImageResource(R.drawable.validated);
            //viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.GREEN));
        else if (intervention.getStatus().equals(FINISHED))
           // viewHolder.avatar.setImageResource(R.drawable.);
            viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.BLACK));
        else if (intervention.getStatus().equals(ASSIGNED))
            viewHolder.avatar.setImageResource(R.drawable.assigned);
            //viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.WHITE));

        return convertView;
    }

    private class InerventionViewHolder{
        public TextView title;
        public TextView description;
        public TextView type;
        public TextView status;
        public ImageView avatar;
        public TextView client;
    }
}
