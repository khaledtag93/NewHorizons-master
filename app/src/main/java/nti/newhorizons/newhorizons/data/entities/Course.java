package nti.newhorizons.newhorizons.data.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

import nti.newhorizons.newhorizons.R;

@Entity
public class Course implements Serializable{
    @PrimaryKey
    private int id;
    private String name;
    private String code;
    private String category;
    private String prerequisites;
    private String description;
    private String outline;
    private String include;
    private String vendor;
    private String level;
    private int hours;
    private int cost;
    private float discount;
    private int image;

    public Course() {
        id =0;
        name = "none";
        code = "none";
        category = "none";
        description = "none";
        outline = "none";
        hours = 0;
        cost = 0;
        discount = 0;
        prerequisites="";
        include="";
        level="";
        vendor="";
        image = R.drawable.logo_app;
    }

    @Ignore
    public Course(int id, String name, String code, String category, String prerequisites, String description, String outline, String include, String vendor, String level, int hours, int cost, float discount, int image) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.category = category;
        this.prerequisites = prerequisites;
        this.description = description;
        this.outline = outline;
        this.include = include;
        this.vendor = vendor;
        this.level = level;
        this.hours = hours;
        this.cost = cost;
        this.discount = discount;
        this.image = image;
    }


    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getDisc() {
        return discount;
    }

    public void setDisc(float disc) {
        discount = disc;
    }
}
