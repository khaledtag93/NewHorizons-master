package nti.newhorizons.newhorizons.data.local.room.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import nti.newhorizons.newhorizons.data.entities.Category;

import static android.arch.persistence.room.OnConflictStrategy.IGNORE;

@Dao
public interface CategoryDao {

    @Query("SELECT * FROM Category")
    LiveData<List<Category>> loadAllCategories();

    @Insert(onConflict = IGNORE)
    void insertCategory(Category category);

    @Query("DELETE FROM Category")
    void deleteAll();
}
