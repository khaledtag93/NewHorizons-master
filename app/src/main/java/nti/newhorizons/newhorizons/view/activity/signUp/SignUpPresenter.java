package nti.newhorizons.newhorizons.view.activity.signUp;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Client;
import nti.newhorizons.newhorizons.utils.ValidationUtils;

public class SignUpPresenter {
    SignUpActivity view;

    public SignUpPresenter(SignUpActivity view) {
        this.view = view;
    }

    public boolean checkIsUserValid() {


        InputMethodManager imm = (InputMethodManager) view.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.nameT.getWindowToken(), 0);

        String user_name = view.nameT.getText().toString().trim();
        String user_phone = view.phoneT.getText().toString().trim();
        String user_email = view.emailT.getText().toString().trim();
        String user_password = view.passwordT.getText().toString().trim();

        view.nameT.setError(null);
        view.phoneT.setError(null);
        view.emailT.setError(null);
        view.passwordT.setError(null);




        boolean cancel = false;
        View focusView = null;

        if (TextUtils.isEmpty(user_password)) {
            view.passwordT.setError(view.getString(R.string.error_invalid_password));
            focusView = view.passwordT;
            cancel = true;
        }
        if (TextUtils.isEmpty(user_email)) {
            view.emailT.setError(view.getString(R.string.error_field_required));
            focusView = view.emailT;
            cancel = true;
        }else
        {
            if(!user_email.matches(ValidationUtils.emailPattern))
            {
                view.emailT.setError(view.getString(R.string.error_field_required));
                focusView = view.emailT;
                cancel = true;
            }
        }
        if (TextUtils.isEmpty(user_name)) {
            view.nameT.setError(view.getString(R.string.error_field_required));
            focusView = view.nameT;
            cancel = true;
        }
        if (TextUtils.isEmpty(user_phone)) {
            view.phoneT.setError(view.getString(R.string.error_field_required));
            focusView = view.phoneT;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            return true;
        }
        return false;
    }

    public Client getClient() {

        String name = view.nameT.getText().toString().trim();
        String phone = view.phoneT.getText().toString().trim();
        String email = view.emailT.getText().toString().trim();
        String password = view.passwordT.getText().toString().trim();

        Client client = new Client();
        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        client.setPassword(password);
        return client;
    }

    public boolean saveClient(Client client){

        return true;
    }
}
