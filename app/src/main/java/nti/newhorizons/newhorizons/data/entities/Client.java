package nti.newhorizons.newhorizons.data.entities;

import java.io.Serializable;

public class Client extends Person implements Serializable{

    private String password;
    private String type;

    public Client() {
        super();
        password="1234";
        type="Individual";
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
