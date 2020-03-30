package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.myapplication.restCalls.Intervention
import com.example.myapplication.restCalls.InterventionRestCall
import com.example.myapplication.restCalls.User
import com.example.myapplication.restCalls.UserRestCall
import com.example.myapplication.views.ViewMethods

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        InterventionRestCall.getAllInterventions()
       val loginButton =findViewById(R.id.loginButton) as  Button
       val login =findViewById(R.id.login) as EditText
        val password =findViewById(R.id.password) as EditText
//
        ViewMethods.login(loginButton,login,password)



// A commenter après la première execution
        UserRestCall.saveUser(User.createInstanceTest_client())
        UserRestCall.saveUser(User.createInstanceTest_admin())
        UserRestCall.saveUser(User.createInstanceTest_normal())

        //InterventionRestCall.saveIntervention(Intervention.createInstanceTest())

       // InterventionRestCall.finishIntervention(5) // 5 l'id de l'intervention: il faut bien verifier l'id avant d'executer cette fonction

    }


}
