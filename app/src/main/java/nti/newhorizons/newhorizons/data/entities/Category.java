package nti.newhorizons.newhorizons.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import nti.newhorizons.newhorizons.R;

@Entity
public class Category {
    @PrimaryKey
    @NonNull
    private String name;
    private int image;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Category() {
        image = R.drawable.logo_app;
        name = "none vendor";
    }
}
