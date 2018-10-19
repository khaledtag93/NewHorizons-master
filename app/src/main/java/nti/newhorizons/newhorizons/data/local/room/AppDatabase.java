package nti.newhorizons.newhorizons.data.local.room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import nti.newhorizons.newhorizons.data.entities.Category;
import nti.newhorizons.newhorizons.data.entities.Course;
import nti.newhorizons.newhorizons.data.local.room.dao.CategoryDao;
import nti.newhorizons.newhorizons.data.local.room.dao.CourseDao;

@Database(entities = {Course.class, Category.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract CourseDao courseModel();
    public abstract CategoryDao categoryModel();


    public static AppDatabase getInMemoryDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                    .allowMainThreadQueries()
                    .build();
        }

        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
