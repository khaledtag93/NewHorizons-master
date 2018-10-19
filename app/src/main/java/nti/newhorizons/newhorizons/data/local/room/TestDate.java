package nti.newhorizons.newhorizons.data.local.room;

import java.util.ArrayList;
import java.util.List;

import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Category;
import nti.newhorizons.newhorizons.data.entities.Course;

public class TestDate {

    public static List<Course> getCourses() {
        List<Course> courses = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            Course course = new Course();
//            course.setId(i);
//            course.setName("name"+i);
//            course.setCategory("C#");
//            courses.add(course);
//        }
        Course course=new Course(0,"The Complete python","D001","Development","Indroduction To Computer Slide","Becaome python Progarammer and learn one of employers most request skills 2018","installing python,Running python code,Strings,Lists,Dictonieries,Tuples,Modules","course introduction,Course Curriculm Over view,Course FAG","Microsoft","Bigginer",24,50,30,R.drawable.microsoft);
        Course course2=new Course(1,"The Complete python","D001","Development","Indroduction To Computer Slide","Becaome python Progarammer and learn one of employers most request skills 2018","installing python,Running python code,Strings,Lists,Dictonieries,Tuples,Modules","course introduction,Course Curriculm Over view,Course FAG","Microsoft","Bigginer",24,50,30,R.drawable.microsoft);

        courses.add(course);
        courses.add(course2);

        return courses;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();


        Category category = new Category();
        category.setImage(R.drawable.microsoft);
        category.setName("microsoft");
        categories.add(category);



        category = new Category();
        category.setImage(R.drawable.orcalee);
        category.setName("orcale");
        categories.add(category);



        category = new Category();
        category.setImage(R.drawable.cisco);
        category.setName("Cisco");
        categories.add(category);



        category = new Category();
        category.setImage(R.drawable.autodisc);
        category.setName("autodisc");
        categories.add(category);



        category = new Category();
        category.setImage(R.drawable.comptia);
        category.setName("comptia");
        categories.add(category);




        return categories;


    }
}