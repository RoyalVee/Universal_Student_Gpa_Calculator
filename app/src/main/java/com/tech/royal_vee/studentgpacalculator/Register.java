package com.tech.royal_vee.studentgpacalculator;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Register extends AppCompatActivity {

    // Creating EditText .
    EditText email, password, fullname ;

    // Creating button.
    Button SignUp;

    // Creating string to hold email and password .
    String EmailHolder, PasswordHolder;

    // Creating Progress dialog.
    ProgressDialog progressDialog;

    // Creating Boolean to hold EditText empty true false value.
    Boolean EditTextEmptyCheck;

    // Creating FirebaseAuth object.
    FirebaseAuth firebaseAuth ;


    String gppa;
    String sua ;
    String tsp ;
    String acc ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // Assigning layout email ID and Password ID.
        email = (EditText)findViewById(R.id.user_email);
        password = (EditText)findViewById(R.id.user_password);


        // Assign button layout ID.
        SignUp = (Button)findViewById(R.id.btn_register);



        // Creating object instance.
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(Register.this);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            gppa = bundle.getString("Gpa");
            sua = bundle.getString("TotalUnit");
            tsp = bundle.getString("TotalPoint");
            acc = bundle.getString("NumCourse");

        }

        if(firebaseAuth.getCurrentUser() != null){

            // Finishing current Login Activity.
            finish();

            // Opening UserProfileActivity .
            Intent intent = new Intent(Register.this, SaveResult.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("Gpa", gppa);
            intent.putExtra("TotalUnit", sua);
            intent.putExtra("TotalPoint", tsp);
            intent.putExtra("NumCourse", acc);
            startActivity(intent);
        }

        // Adding click listener to Sign Up Button.
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling method to check EditText is empty or no status.
                CheckEditTextIsEmptyOrNot();

                // If EditText is true then this block with execute.
                if(EditTextEmptyCheck){

                    // If EditText is not empty than UserRegistrationFunction method will call.
                    UserRegistrationFunction();

                }
                // If EditText is false then this block with execute.
                else {

                    Toast.makeText(Register.this, "Please fill all form fields.", Toast.LENGTH_LONG).show();

                }

            }
        });


    }

    public void CheckEditTextIsEmptyOrNot(){

        // Getting value form Email's EditText and fill into EmailHolder string variable.
        EmailHolder = email.getText().toString().trim();

        // Getting value form Password's EditText and fill into PasswordHolder string variable.
        PasswordHolder = password.getText().toString().trim();

        // Checking Both EditText is empty or not.
        if(TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder))
        {

            // If any of EditText is empty then set value as false.
            EditTextEmptyCheck = false;

        } else {

            // If any of EditText is empty then set value as true.
            EditTextEmptyCheck = true ;

        }

    }

    // Creating UserRegistrationFunction
    public void UserRegistrationFunction(){

        // Showing progress dialog at user registration time.
        progressDialog.setMessage("Please Wait, We are Registering Your Data on Server");
        progressDialog.show();

        // Creating createUserWithEmailAndPassword method and pass email and password inside it.
        firebaseAuth.createUserWithEmailAndPassword(EmailHolder, PasswordHolder).
                addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // Checking if user is registered successfully.
                        if(task.isSuccessful()){

                            // If user registered successfully then show this toast message.
                            Toast.makeText(Register.this,"User Registration Successfully",Toast.LENGTH_LONG).show();

                            // Opening the JournalEntry Activity
                            Intent intent = new Intent(Register.this, SaveResult.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.putExtra("Gpa", gppa);
                            intent.putExtra("TotalUnit", sua);
                            intent.putExtra("TotalPoint", tsp);
                            intent.putExtra("NumCourse", acc);
                            startActivity(intent);



                        }else{

                            // If something goes wrong.
                            Toast.makeText(Register.this,"Something Went Wrong.",Toast.LENGTH_LONG).show();
                        }

                        // Hiding the progress dialog after all task complete.
                        progressDialog.dismiss();

                    }
                });

    }

}
