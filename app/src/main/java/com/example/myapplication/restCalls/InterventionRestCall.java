package com.example.myapplication.restCalls;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.myapplication.MainActivity;
import com.example.myapplication.views.InterventionAdapter;
import com.example.myapplication.views.UserAdapter;
import com.example.myapplication.views.ViewMethods;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import cz.msebera.android.httpclient.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class InterventionRestCall {
    public static void saveIntervention( Intervention intervention)
    {
        RequestParams params = new RequestParams();

        params.put("title",intervention.getTitle());
        params.put("description", intervention.getDescription());
        params.put("type",intervention.getType());
        params.put("status", intervention.getStatus());


        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.post("http://10.0.2.2:8090/intervention/save", params, new AsyncHttpResponseHandler() {
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

    public static void saveInvoice(Invoice invoice, Intervention intervention)
    {
        RequestParams params = new RequestParams();


        params.put("tasks_done",invoice.getTasksDone());
        params.put("tasks_not_done", invoice.getTasksNotDone());
        params.put("cost",invoice.getCost());
        params.put("intervention", invoice.getIntervention());


        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.post("http://10.0.2.2:8090/invoice/save/"+intervention.getId(), params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println("sucesssssssssssssssssss -----------"+response.toString());


                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

    public static void updateIntervention( Intervention intervention)
    {
        RequestParams params = new RequestParams();

        params.put("id",intervention.getId());
        params.put("title",intervention.getTitle());
        params.put("description", intervention.getDescription());
        params.put("type",intervention.getType());
        params.put("status", intervention.getStatus());


        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.put("http://10.0.2.2:8090/intervention/update", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                try {
                    System.out.println(response.get("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;

    }

    public static void affectIntervention(Integer idIntervention,  Integer idUser)
    {
        RequestParams params = new RequestParams();



        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.put("http://10.0.2.2:8090/intervention/affect/"+idIntervention+"/"+idUser, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                try {
                    System.out.println(response.get("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;


    }

    public static void finishIntervention(Integer idIntervention)
    {
        RequestParams params = new RequestParams();



        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.put("http://10.0.2.2:8090/intervention/finish/"+idIntervention, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                try {
                    System.out.println(response.get("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;

    }

    public static void inProgressIntervention(Integer idIntervention)
    {
        RequestParams params = new RequestParams();



        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.put("http://10.0.2.2:8090/intervention/inProgress/"+idIntervention, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                try {
                    System.out.println(response.get("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;

    }

    public static void validateIntervention(Integer idIntervention)
    {
        RequestParams params = new RequestParams();



        params.setUseJsonStreamer(true);
        AsyncHttpClient client = new AsyncHttpClient();

        client.put("http://10.0.2.2:8090/intervention/validate/"+idIntervention, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                System.out.println(response.toString());
                try {
                    System.out.println(response.get("title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                // toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;


    }

    public static void getAllInterventionsForCurrentClient(final ListView listeView, final InterventionListActivity activity,String clientUser)
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://10.0.2.2:8090/intervention/getAllInterventionsForClient/"+clientUser, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                System.out.println(response.toString());
                System.out.println("------------interventions----- "+response.toString());
                List<Intervention> interventions = new ArrayList<Intervention>();
                for(int i =0; i<response.length();i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Intervention inter = new Intervention();

                        inter.setId((Integer) obj.get("id"));
                        inter.setTitle((String)obj.get("title"));
                        inter.setDescription((String)obj.get("description"));
                        /*if(obj.get("client")!= null )
                        inter.setClient((String)obj.get("client"));
                        if(obj.get("type") != null)
                       inter.setType((String) obj.get("type"));*/
                        inter.setStatus((String) obj.get("status"));
                        inter.setDateIntervention((String) obj.get("dateIntervention"));
                        interventions.add(inter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                InterventionAdapter adapter = new InterventionAdapter(activity.getApplicationContext(), interventions);
                listeView.setAdapter(adapter);
                listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                        Intervention intervention = (Intervention)listeView.getItemAtPosition(position);
                        System.out.println(intervention.getTitle());

                        Intent intent = new Intent(v.getContext(),InterventionDescriptionActivity.class);
                        intent.putExtra("title", intervention.getTitle());
                        intent.putExtra("type", intervention.getType());
                        intent.putExtra("client", intervention.getClient());
                        intent.putExtra("description", intervention.getDescription());
                        intent.putExtra("status", intervention.getStatus());
                        intent.putExtra("dateIntervention", intervention.getDateIntervention());
                        System.out.println("-------------------- "+intervention.getId());
                        intent.putExtra("id",""+intervention.getId());
                        v.getContext().startActivity(intent);


                    }
                });
                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();


                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }


    public static void getAllInterventionsForCurrentUser(final ListView listeView, final InterventionListActivity activity,Integer idUser)
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();

        client.get("http://10.0.2.2:8090/intervention/getAllInterventionsForCurrentUser/"+idUser, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                System.out.println(response.toString());
                System.out.println("------------interventions----- "+response.toString());
                List<Intervention> interventions = new ArrayList<Intervention>();
                for(int i =0; i<response.length();i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Intervention inter = new Intervention();

                        inter.setId((Integer) obj.get("id"));
                        inter.setTitle((String)obj.get("title"));
                        inter.setDescription((String)obj.get("description"));
                        /*if(obj.get("client")!= null )
                        inter.setClient((String)obj.get("client"));
                        if(obj.get("type") != null)
                       inter.setType((String) obj.get("type"));*/
                        inter.setStatus((String) obj.get("status"));
                        inter.setDateIntervention((String) obj.get("dateIntervention"));
                        interventions.add(inter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                InterventionAdapter adapter = new InterventionAdapter(activity.getApplicationContext(), interventions);
                listeView.setAdapter(adapter);
                listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                        Intervention intervention = (Intervention)listeView.getItemAtPosition(position);
                            System.out.println(intervention.getTitle());

                        Intent intent = new Intent(v.getContext(),InterventionDescriptionActivity.class);
                        intent.putExtra("title", intervention.getTitle());
                        intent.putExtra("type", intervention.getType());
                        intent.putExtra("client", intervention.getClient());
                        intent.putExtra("description", intervention.getDescription());
                        intent.putExtra("status", intervention.getStatus());
                        intent.putExtra("dateIntervention", intervention.getDateIntervention());
                        System.out.println("-------------------- "+intervention.getId());
                        intent.putExtra("id",""+intervention.getId());
                        v.getContext().startActivity(intent);


                    }
                });
                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();


                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

    public static void getAllInterventions(final ListView listeView, final InterventionAllListActivity activity)
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
params.setUseJsonStreamer(true);
        client.get("http://10.0.2.2:8090/intervention/getAllInterventions", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                System.out.println("------------interventionsalll-----***----- "+response.toString());
               List<Intervention> interventions = new ArrayList<Intervention>();
                for(int i =0; i<response.length();i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Intervention inter = new Intervention();
                        inter.setId((Integer) obj.get("id"));
                        inter.setTitle((String)obj.get("title"));
                        inter.setDescription((String)obj.get("description"));
                       inter.setType((String) obj.get("type"));
                        inter.setStatus((String) obj.get("status"));
                        inter.setDateIntervention((String) obj.get("dateIntervention"));

                        if(!obj.isNull("user"))
                        {
                            String firstName = (String) obj.getJSONObject("user").get("firstName");
                            String lastName = (String) obj.getJSONObject("user").get("lastName");
                                inter.setFullUserName(firstName+" "+lastName);
                        }
                        else
                        {
                            inter.setFullUserName("");
                        }

                        interventions.add(inter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                InterventionAdapter adapter = new InterventionAdapter(activity.getApplicationContext(), interventions);
                listeView.setAdapter(adapter);

                listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {

                        Intervention intervention = (Intervention)listeView.getItemAtPosition(position);
                        System.out.println(intervention.getTitle());

                        Intent intent = new Intent(v.getContext(),InterventionDescriptionAdminActivity.class);
                        intent.putExtra("title", intervention.getTitle());
                        intent.putExtra("type", intervention.getType());
                        intent.putExtra("client", intervention.getClient());
                        intent.putExtra("description", intervention.getDescription());
                        intent.putExtra("status", intervention.getStatus());
                        intent.putExtra("dateIntervention", intervention.getDateIntervention());
                        intent.putExtra("user", intervention.getFullUserName());
                        System.out.println("--------------ffffff------ "+intervention.getFullUserName());
                        intent.putExtra("id",""+intervention.getId());
                        v.getContext().startActivity(intent);


                    }
                });
                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

    public static void getAllUsers(final ListView listeView, final UserListActivity activity, final Integer idIntervention, final String title)
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        params.setUseJsonStreamer(true);
        client.get("http://10.0.2.2:8090/user/getAllUsers", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                System.out.println("------------interventionsalll-----***----- "+response.toString());
                List<User> users = new ArrayList<User>();
                for(int i =0; i<response.length();i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        User user = new User();
                        user.setId((Integer) obj.get("id"));
                        user.setFirstName((String) obj.get("firstName"));
                        user.setLastName((String) obj.get("lastName"));



                        users.add(user);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                UserAdapter adapter = new UserAdapter(activity.getApplicationContext(), users);
                listeView.setAdapter(adapter);

                listeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, final View v, int position, long arg3) {
                      final  User user = (User)listeView.getItemAtPosition(position);
                        RequestParams params1 = new RequestParams();
                        AsyncHttpClient client1 = new AsyncHttpClient();

                        System.out.println("---------hhhh---------- "+idIntervention+"   "+user.getId());

                        client1.put("http://10.0.2.2:8090/intervention/affect/"+idIntervention+"/"+user.getId(), params1, new JsonHttpResponseHandler() {
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                                // Handle resulting parsed JSON response here
                                System.out.println(response.toString());
                                try {
                                    System.out.println(response.get("title"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Toast toast = Toast.makeText(activity.getApplicationContext(), "The intervention "+title+" was affected to "+user.getFirstName()+" "+user.getLastName(), Toast.LENGTH_SHORT);
                                toast.show();
                                Intent intent = new Intent(v.getContext(),InterventionAllListActivity.class);
                                v.getContext().startActivity(intent);
                                // Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                                // toast.show();
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                            }
                        }) ;



                    }
                });
                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

    public static void getAllInterventions()
    {
        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        params.setUseJsonStreamer(true);
        client.get("http://10.0.2.2:8090/intervention/getAllInterventions", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                System.out.println("------------interventions----- "+response.toString());
               /* List<Intervention> interventions = new ArrayList<Intervention>();
                for(int i =0; i<response.length();i++)
                {
                    try {
                        JSONObject obj = response.getJSONObject(i);

                        Intervention inter = new Intervention();
                        inter.setTitle((String)obj.get("title"));
                        inter.setDescription((String)obj.get("description"));
                        inter.setType((String) obj.get("type"));
                        inter.setStatus((String) obj.get("status"));
                        interventions.add(inter);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                InterventionAdapter adapter = new InterventionAdapter(activity.getApplicationContext(), interventions);
                listeView.setAdapter(adapter);*/
                //Toast toast = Toast.makeText(main.getApplicationContext(), "Hello toast!", Toast.LENGTH_SHORT);
                //toast.show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String res, Throwable t) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
            }
        }) ;
    }

}
