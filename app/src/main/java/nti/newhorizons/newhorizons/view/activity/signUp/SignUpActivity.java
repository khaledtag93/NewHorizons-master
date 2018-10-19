package nti.newhorizons.newhorizons.view.activity.signUp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Client;
import nti.newhorizons.newhorizons.utils.ValidationUtils;
import nti.newhorizons.newhorizons.utils.ViewUtils;
import nti.newhorizons.newhorizons.view.activity.main.MainActivity;

public class SignUpActivity extends AppCompatActivity {

    EditText nameT, phoneT, emailT, passwordT;
    Button signup;
    SignUpPresenter presenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtils.hideActionBar(this);
        setContentView(R.layout.activity_signup);

        init();
        presentData();
        actions();

    }

    private void presentData() {

    }

    private void init() {
        nameT = findViewById(R.id.et_signup_name);
        phoneT = findViewById(R.id.et_signup_phone);
        emailT = findViewById(R.id.et_signup_email);
        passwordT = findViewById(R.id.et_signup_password);
        signup = findViewById(R.id.btn_signup);
        presenter = new SignUpPresenter(this);

    }

    private void actions() {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check validation
                if (!presenter.checkIsUserValid()) {
                    return;
                }

                //save client in dataBase
                if (!presenter.saveClient(presenter.getClient())) {
                    Toast.makeText(SignUpActivity.this, "Client Not Saved in DB", Toast.LENGTH_SHORT).show();
                    return;
                }

                //start Main Activity
                Client client = new Client();
                Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                intent.putExtra("Client", client);
                startActivity(intent);
            }


        });

    }


}