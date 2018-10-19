package nti.newhorizons.newhorizons.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import nti.newhorizons.newhorizons.R;
import nti.newhorizons.newhorizons.data.entities.Course;

import java.util.ArrayList;


public class CourseListAdapter  extends ArrayAdapter<Course> {

    TextView tvCourseName, tvCoursDesc;
    ImageView ivCourseImg, ivAddToList;
    private final ArrayList<Course> courses;
    private final Context context;

    public CourseListAdapter(@NonNull Context context,ArrayList<Course> courses) {
        super(context, R.layout.course_list_item,courses);
        this.context=context;
        this.courses=courses;



    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view1, @NonNull ViewGroup parent) {

        LayoutInflater inflater= (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.course_list_item,parent,false);
        tvCourseName=(TextView) view.findViewById(R.id.tv_course_list_name);
        tvCoursDesc =(TextView)view.findViewById(R.id.tv_list_course_des);
        ivCourseImg=(ImageView)view.findViewById(R.id.iv_course_list_icon) ;
        ivAddToList=(ImageView)view.findViewById(R.id.iv_add_toList) ;

        tvCourseName.setText(courses.get(position).getName());
        tvCoursDesc.setText(courses.get(position).getDescription());
        ivCourseImg.setImageResource(courses.get(position).getImage());
        ivAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"you clicked add to list",Toast.LENGTH_LONG).show();
            }
        });



        return view;
    }


}
