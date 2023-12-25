package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.Model.Data;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class InsertJobPostActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private EditText job_tilte;
    private EditText job_desciption;

    private EditText job_skill;
    private EditText job_salary;
    private Button btn_post_job;

    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);

        toolbar.findViewById(R.id.insert_job_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Post job");

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();
        mJobPost= FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);


        InsertJob();
    }

    private void InsertJob(){
        job_tilte=findViewById(R.id.job_tilte);
        job_desciption=findViewById(R.id.job_discription);
        job_skill=findViewById(R.id.job_skill);
        job_salary=findViewById(R.id.job_salary);

        btn_post_job=findViewById(R.id.btn_job_post);
        btn_post_job.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tilte =job_tilte.getText().toString().trim();
                String description=job_desciption.getText().toString().trim();
                String skill=job_skill.getText().toString().trim();
                String salary=job_salary.getText().toString().trim();

                if(TextUtils.isEmpty(tilte)){
                    job_tilte.setError("Required");
                    return;
                }
                if(TextUtils.isEmpty(description)){
                    job_desciption.setError("Required");
                    return;
                }
                if(TextUtils.isEmpty(skill)){
                    job_skill.setError("Required");
                    return;
                }
                if(TextUtils.isEmpty(salary)){
                    job_salary.setError("Required");
                    return;
                }

                String id=mJobPost.push().getKey();
                String date= DateFormat.getDateInstance().format(new Date());
                Data data=new Data(tilte,description,skill,salary,id, date);
                mJobPost.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));

            }
        });
    }
}