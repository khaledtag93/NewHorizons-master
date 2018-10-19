package nti.newhorizons.newhorizons.data.entities;

public class Registration {

    private int client_id;
    private int course_id;
    private int schedule_id;
    public Registration() {
        super();
    }
    public int getClient_id() {
        return client_id;
    }
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }
    public int getCourse_id() {
        return course_id;
    }
    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public int getSchedule_id() {
        return schedule_id;
    }
    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }

}

