package nti.newhorizons.newhorizons.data.entities;

import java.util.Date;

public class Attendance {

    private Date date;
    private int client_id;
    private int schedule_id;
    public Attendance() {
        super();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {   //date format should be handled before calling setDate() ..!

        this.date = date;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getSchedule_id() {
        return schedule_id;
    }

    public void setSchedule_id(int schedule_id) {
        this.schedule_id = schedule_id;
    }


}