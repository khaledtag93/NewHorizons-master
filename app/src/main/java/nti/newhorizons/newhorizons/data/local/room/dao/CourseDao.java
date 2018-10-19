package nti.newhorizons.newhorizons.data.local.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import nti.newhorizons.newhorizons.data.entities.Course;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface CourseDao {

    @Query("SELECT * FROM Course")
    LiveData<List<Course>> loadAllCourses();

    @Query("SELECT * FROM Course where Course.category like :category")
    LiveData<List<Course>> findCoursesByCategory(String category);

    @Query("SELECT * FROM Course")
    LiveData<List<Course>> loadMostPopularCourses();

    @Query("SELECT * FROM Course")
    LiveData<List<Course>> loadSuggestedCourses();

    @Insert(onConflict = IGNORE)
    void insertCourse(Course course);

    @Insert(onConflict = IGNORE)
    void insertCourses(List<Course> courses);

    @Query("DELETE FROM Course")
    void deleteAll();
}
