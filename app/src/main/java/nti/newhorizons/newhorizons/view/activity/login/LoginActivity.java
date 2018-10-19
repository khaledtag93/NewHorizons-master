package nti.newhorizons.newhorizons.view.activity.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Client;
import nti.newhorizons.newhorizons.view.activity.main.MainActivity;
import nti.newhorizons.newhorizons.view.activity.signUp.SignUpActivity;

public class LoginActivity extends AppCompatActivity {
    EditText emailT, passwordT;
    Button login;
    TextView signup, skip;
    LoginPresenter loginPresenter;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    Client testClient = new Client();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);
        init();
        actions();
    }

    private void init() {

        emailT = findViewById(R.id.et_login_email);
        passwordT = findViewById(R.id.et_login_password);
        signup = findViewById(R.id.et_signup);
        skip = findViewById(R.id.tv_skip);
        login = findViewById(R.id.btn_login);

        loginPresenter = new LoginPresenter();
    }

    private void actions() {
        signup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login_email = emailT.getText().toString().trim();
                String login_password = passwordT.getText().toString().trim();
                if (checkIsUserValid()) {

                    Client user = loginPresenter.checkUser(login_email, login_password);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtra("Client", user);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private boolean checkIsUserValid() {

        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(emailT.getWindowToken(), 0);


        emailT.setError(null);
        passwordT.setError(null);

        String email = emailT.getText().toString();
        String password = passwordT.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(password)) {
            passwordT.setError(getString(R.string.error_invalid_password));
            focusView = passwordT;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            emailT.setError(getString(R.string.error_field_required));
            focusView = emailT;
            cancel = true;
        } else if (!email.matches(emailPattern)) {
            emailT.setError(getString(R.string.error_field_required));
            focusView = emailT;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            return true;
        }
        return false;
    }


}