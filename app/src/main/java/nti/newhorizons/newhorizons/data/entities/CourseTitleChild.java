package nti.newhorizons.newhorizons.data.entities;

/**
 * Created by reale on 23/11/2016.
 */

public class CourseTitleChild {

    String option1;
    String option2;
    String option3;
    int imgID;

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public CourseTitleChild(String option1, String option2, String option3, int imgID) {
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.imgID = imgID;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }
}
