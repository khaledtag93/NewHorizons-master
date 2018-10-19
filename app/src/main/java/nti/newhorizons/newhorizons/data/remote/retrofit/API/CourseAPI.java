package nti.newhorizons.newhorizons.data.remote.retrofit.API;

import java.util.List;

import nti.newhorizons.newhorizons.data.entities.Course;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CourseAPI {

    @GET("/apicourse/all")
    Call<List<Course>> getallCourses();

    @GET("/course")
    Call<List<Course>> getCoursesByCategory(@Query("categoryName") String categoryName);

    @GET("/course")
    Call<List<Course>> getCoursesById(@Query("id") String categoryid);

}
