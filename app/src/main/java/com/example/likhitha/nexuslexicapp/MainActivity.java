package com.example.likhitha.nexuslexicapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {
    CharSequence username;
    boolean isTeacher = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText usernameEditText = (EditText)findViewById(R.id.username_edit_text);
        EditText passwordEditText = (EditText)findViewById(R.id.password_edit_text);

        username = usernameEditText.getText();
        Button signIn = (Button) findViewById(R.id.sign_in_button);


        View.OnClickListener signInButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isTeacher) {
                    //Launch Teacher Screen or Teacher Activity
                    startTeacherActivity();
                } else {
                    //Launch student screen or student activity
                    startStudentActivity();
                }
            }

        }   ;


        signIn.setOnClickListener(signInButtonListener);

        Button exit = (Button) findViewById(R.id.exit_button);

        View.OnClickListener exitButtonListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };
        exit.setOnClickListener(exitButtonListener);

    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item)

    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void startTeacherActivity() {
        Intent teacherIntent = new Intent(this, TeacherActivity.class);
        startActivity(teacherIntent);
    }

    void startStudentActivity() {
        Intent studentIntent = new Intent(this, StudentActivity.class);
        startActivity(studentIntent);
    }
}

