package nti.newhorizons.newhorizons.data.entities;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reale on 23/11/2016.
 */

public class HollowDataCreator {
    static HollowDataCreator _titleCreator;
    List<CourseTitleParent> _Course_titleParents;

    public HollowDataCreator(Context context) {
        _Course_titleParents = new ArrayList<>();
        for(int i=1;i<=100;i++)
        {
            CourseTitleParent title = new CourseTitleParent(String.format("Caller #%d",i));
            _Course_titleParents.add(title);
        }
    }

    public static HollowDataCreator get(Context context)
    {
        if(_titleCreator == null)
            _titleCreator = new HollowDataCreator(context);
        return _titleCreator;
    }

    public List<CourseTitleParent> getAll() {
        return _Course_titleParents;
    }
}
