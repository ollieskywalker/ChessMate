package com.example.windows10user.chessmate;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

public class LogIn extends AppCompatActivity {
Button button_login, button_create_new_account;
    EditText editText_username,editText_password;
    static String USERNAME="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Backendless.initApp(getApplicationContext(), "5D8AA47B-02C1-D7C2-FF41-3A2B7FAC6600", "F55D219C-44FC-C7CD-FFFD-D83453B97A00", "v1");
        setContentView(R.layout.activity_log_in);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout(width,(int)(height*0.5));

        wireWidget();
    }

    private void wireWidget() {
        button_create_new_account = (Button)findViewById(R.id.activity_log_in_createnewaccount_button);
        button_login=(Button)findViewById(R.id.activity_log_in_button_submit);
        editText_password = (EditText)findViewById(R.id.activity_log_in_edittext_password);
        editText_username = (EditText)findViewById(R.id.activity_log_in_edittext_username);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Backendless.UserService.login(editText_username.getText().toString(), editText_password.getText().toString(), new AsyncCallback<BackendlessUser>() {
                    @Override
                    public void handleResponse(BackendlessUser response) {
                        USERNAME = editText_username.getText().toString();
                        finish();
                    }

                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Toast.makeText(LogIn.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


        button_create_new_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.create_new_account);
                button_login=(Button)findViewById(R.id.create_new_account_button_submit);
                editText_password = (EditText)findViewById(R.id.create_new_account_button_password);
                editText_username = (EditText)findViewById(R.id.create_new_account_edit_text_name);

                button_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        BackendlessUser backendlessUser = new BackendlessUser();
                        backendlessUser.setEmail(editText_username.getText().toString());
                        backendlessUser.setPassword(editText_password.getText().toString());
                        Backendless.UserService.register(backendlessUser, new AsyncCallback<BackendlessUser>() {
                            @Override
                            public void handleResponse(BackendlessUser response) {
                                finish();
                            }

                            @Override
                            public void handleFault(BackendlessFault fault) {
                                Toast.makeText(LogIn.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });
            }
        });
    }
}
