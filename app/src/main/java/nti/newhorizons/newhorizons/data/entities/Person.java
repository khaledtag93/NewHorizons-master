package nti.newhorizons.newhorizons.data.entities;

import java.io.Serializable;

public class Person  implements Serializable {
    protected int id;
    protected String name;
    protected String phone;
    protected String email;


    public Person() {
        id=0;
        name="default";
        phone="0000";
        email="default@gmail.com";

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
