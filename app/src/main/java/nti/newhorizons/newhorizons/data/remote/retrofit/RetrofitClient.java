package nti.newhorizons.newhorizons.data.remote.retrofit;

import android.util.Log;
import android.widget.Toast;

import java.util.List;

import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.data.remote.retrofit.API.CourseAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static String BASE_URL = "http://localhost:8080";
    private static Retrofit retrofit;


    // use singleton design pattern to create single instance of RetrofitClient for the app
    public static Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static void callCourseAPI()
    {
            Log.e("tigoo","courses :(");
        CourseAPI api = retrofit.create(CourseAPI.class);
        Call<List<Course>> call = api.getallCourses();
        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courses = response.body();
                Log.e("tag",courses+"  wala ya wala");
                for (Course course:courses) {

                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
            }
        });
    }

}
