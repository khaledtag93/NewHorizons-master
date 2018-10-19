package nti.newhorizons.newhorizons.data.entities;

import android.text.format.Time;

import java.util.Date;

public class Schedule {

    private int id;
    private int course_id;
    private Time start_time;
    private int labNum;
    private String branchName;
    private Date startDate;
    private Date endDate ;

    public Schedule() {
        super();
    }

    public int getId() {
        return id;
    }

    public int getLabNum() {
        return labNum;
    }

    public void setLabNum(int labNum) {
        this.labNum = labNum;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }


}
