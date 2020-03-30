package com.example.myapplication.restCalls;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;


public class UserRestCall {
    public static boolean successLOgin=false;
    public static Integer connectedIdUser;
    public static String connectedUser_login;
    public static boolean isClient=false;
    public static boolean isAdmin = false;
    public static String clientUser="INTERNAL- GOOD WILL";
    public static void getUser(String login, String password, final View v)
    {
        RequestParams params = new RequestParams();
        final AsyncHttpClient client = new AsyncHttpClient();


        client.get("http://10.0.2.2:8090/user/isFound/"+login+"/"+password, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here


                if(response != null)
                {
                    System.out.println("--------------- user found: "+response.toString());
                    successLOgin = true;
                    try {
                        System.out.println("--------------- connectedIdUser: "+response.get("id"));
                        connectedIdUser= (Integer) response.get("id");
                        if(connectedIdUser != null)
                        {
                            connectedUser_login=(String)response.get("login");
                        }
                        System.out.println("--------------- connectedIdUser: "+connectedIdUser);
                        Intent intent;
                        if((Boolean)response.get("isExternal")==true)
                        {
                            intent = new Intent(v.getContext(),MainDashbordClientActivity.class);
                            isClient=true;
                            if(response.get("client") != null)
                            {
                                clientUser=(String)response.get("client");
                            }

                        }

                        else if ((Boolean)response.get("isAdmin")==true)
                        {
                            // intent = new Intent(v.getContext(),InterventionAllListActivity.class);
                            intent = new Intent(v.getContext(),MainDashbordAdminActivity.class);
                            isAdmin=true;
                        }

                        else
                            intent = new Intent(v.getContext(),InterventionListActivity.class);
                        v.getContext().startActivity(intent);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    /*Intent intent = new Intent(v.getContext(),InterventionListActivity.class);*/
                    /*Intent intent = new Intent(v.getContext(),InterventionCreateActivity.class);*/
                   // Intent intent = new Intent(v.getContext(),InterventionAllListActivity.class);

                }
                /*try {
                    System.out.println(response.get("login"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
               // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
               // toast.show();*/

                }




            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                new AlertDialog.Builder(v.getContext())
                        .setTitle("User not found")
                        .setMessage("Thanks to verify your login and password.")

                        // Specifying a listener allows you to take an action before dismissing the dialog.
                        // The dialog is automatically dismissed when a dialog button is clicked.
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Continue with delete operation
                            }
                        })

                        // A null listener allows the button to dismiss the dialog and take no further action.
                        //.setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }) ;

    }

    public static void saveIntervention(final InterventionCreateActivity activity,final View v, final Intervention intervention)
        {
            System.out.println("titleeeeee---------------"+intervention.getTitle());

            RequestParams params = new RequestParams();
            params.put("title",intervention.getTitle());
            params.put("type", intervention.getType());
            params.put("description",intervention.getDescription());
            params.put("client", intervention.getClient());
            params.put("dateIntervention", intervention.getDateIntervention());

            params.setUseJsonStreamer(true);
            AsyncHttpClient client = new AsyncHttpClient();

            client.post("http://10.0.2.2:8090/intervention/save", params, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                    // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                    // Handle resulting parsed JSON response here
                    //System.out.println(response.toString());
                    //Toast toast = Toast.makeText(activity.getApplicationContext(), "The intervention "+intervention.getTitle()+" was saved", Toast.LENGTH_SHORT);
                    //toast.show();
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Intervention request saved")
                            .setMessage("Your intervention request was successfully saved.")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            //.setNegativeButton(android.R.string.no, null)
                            .setIcon(R.drawable.validated)
                            .show();
                    Intent intent = new Intent(v.getContext(),InterventionCreateActivity.class);
                    v.getContext().startActivity(intent);
                /*try {
                    System.out.println(response.get("login"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                    // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                    // toast.show();
                }

                @Override
                public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("Intervention request saved")
                            .setMessage("Your intervention request was successfully saved.")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent(v.getContext(),MainDashbordClientActivity.class);
                                    v.getContext().startActivity(intent);
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            //.setNegativeButton(android.R.string.no, null)
                            .setIcon(R.drawable.validated)
                            .show();

                    /*new AlertDialog.Builder(v.getContext())
                            .setTitle("Intervention not saved")
                            .setMessage("Thanks to verify the intervention information.")

                            // Specifying a listener allows you to take an action before dismissing the dialog.
                            // The dialog is automatically dismissed when a dialog button is clicked.
                            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Continue with delete operation
                                }
                            })

                            // A null listener allows the button to dismiss the dialog and take no further action.
                            //.setNegativeButton(android.R.string.no, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();*/
                }
            }) ;
        }


    public static void saveUser( User user)
    {
        RequestParams params = new RequestParams();

        params.put("login",user.getLogin());
        params.put("password", user.getPassword());
        params.put("email",user.getEmail());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("phoneNumber",user.getPhoneNumber());
        params.put("team", user.getTeam());
        params.put("teamLeader", user.getTeamLeader());
        params.put("actualFunction", user.getActualFunction());
        params.put("isExternal",user.getIsExternal());
        params.put("isAdmin", user.getIsAdmin());
        params.put("numberOfConnecions", user.getNumberOfConnecions());
        params.put("uniqId", user.getUniqId());
        params.put("originalEstablishment", user.getOriginalEstablishment());
        params.put("speciality", user.getSpeciality());
        params.put("birthDate", user.getBirthDate());
        params.put("civilStatus", user.getCivilStatus());
        params.put("streetAddress", user.getStreetAddress());
        params.put("postalCode", user.getPostalCode());
        params.put("client", user.getClient());

        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();
       // StringEntity entity = new StringEntity(params.toString());
//entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

client.post("http://10.0.2.2:8090/user/save", params, new AsyncHttpResponseHandler() {
    @Override
    public void onSuccess(int statusCode, Header[] headers, byte[] response) {
        System.out.println(response.toString());
        System.out.println("save");
    }

    @Override
    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
    }
});

    }

    public static void updateUser(User user)
    {
        RequestParams params = new RequestParams();

        params.put("id",user.getId());
        params.put("login",user.getLogin());
        params.put("password", user.getPassword());
        params.put("email",user.getEmail());
        params.put("firstName", user.getFirstName());
        params.put("lastName", user.getLastName());
        params.put("phoneNumber",user.getPhoneNumber());
        params.put("team", user.getTeam());
        params.put("teamLeader", user.getTeamLeader());
        params.put("actualFunction", user.getActualFunction());
        params.put("isExternal",user.getIsExternal());
        params.put("isAdmin", user.getIsAdmin());
        params.put("numberOfConnecions", user.getNumberOfConnecions());
        params.put("uniqId", user.getUniqId());
        params.put("originalEstablishment", user.getOriginalEstablishment());
        params.put("speciality", user.getSpeciality());
        params.put("birthDate", user.getBirthDate());
        params.put("civilStatus", user.getCivilStatus());
        params.put("streetAddress", user.getStreetAddress());
        params.put("postalCode", user.getPostalCode());

        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();
        // StringEntity entity = new StringEntity(params.toString());
//entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));

        client.put("http://10.0.2.2:8090/user/update", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                /*try {
                    System.out.println(response.get("login"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }*/
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

}
