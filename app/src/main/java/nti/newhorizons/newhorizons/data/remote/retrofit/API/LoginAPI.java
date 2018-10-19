package nti.newhorizons.newhorizons.data.remote.retrofit.API;

import nti.newhorizons.newhorizons.data.entities.Client;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface LoginAPI {

    @POST("/login")
    Call<Client> login(@Field("email") String email, @Field("password") String password);

}
