package nti.newhorizons.newhorizons.view.activity.login;

import android.view.View;


import nti.newhorizons.newhorizons.data.entities.Client;
import nti.newhorizons.newhorizons.data.remote.retrofit.RetrofitClient;

public class LoginPresenter {
    RetrofitClient retrofitClient;

    View context;

    public LoginPresenter(View context) {

        this.context = context;
    }

    public LoginPresenter() {
        retrofitClient=new RetrofitClient();
    }


    public Client checkUser(String email, String password) {
        Client user = new Client();

        user.setEmail(email);
        user.setPassword(password);


        return user;
    }

}
