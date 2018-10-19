package nti.newhorizons.newhorizons.data.entities;


public class Instructor extends Person {

    private int id;
    private String cv=null;

    public Instructor() {
        super();
    }

    public Instructor(int id, String cv) {
        super();
        this.id = id;
        this.cv = cv;
    }

    public int getId() {
        return id;
    }


    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }


}

