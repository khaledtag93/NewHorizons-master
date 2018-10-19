package nti.newhorizons.newhorizons.view.fragment.courseList;

import java.util.ArrayList;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.adapter.CourseListAdapter;
import nti.newhorizons.newhorizons.data.entities.Course;

public class CourseListPresenter {
    ArrayList<Course> courses;
    CourseListFragment view;
    CourseListAdapter adapter;


    public CourseListPresenter(CourseListFragment courseListFragment) {
        courses=new ArrayList<>();
        view=courseListFragment;

        Course course=new Course();
        course.setImage(R.mipmap.ic_java_course_item);
        course.setName("Java");
        course.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course);

        Course course1=new Course();
        course1.setImage(R.mipmap.ic_php);
        course1.setName("Php");
        course1.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course1);

        Course course2=new Course();
        course2.setImage(R.mipmap.ic_python);
        course2.setName("Python");
        course2.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course2);

        Course course3=new Course();
        course3.setImage(R.mipmap.ic_c_plus);
        course3.setName("C++");
        course3.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course3);

        Course course4=new Course();
        course4.setImage(R.mipmap.ic_c_sharp);
        course4.setName("C#");
        course4.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course4);

        Course course5=new Course();
        course5.setImage(R.mipmap.ic_python);
        course5.setName("Python");
        course5.setDescription("learn one of the most important programming language in web development and mobile app");
        courses.add(course5);
    }

    public void setCourseListAdapter()
    {
        CourseListAdapter adapter=new CourseListAdapter(view.getActivity(),courses);
        view.lvCourses.setAdapter(adapter);
    }
}