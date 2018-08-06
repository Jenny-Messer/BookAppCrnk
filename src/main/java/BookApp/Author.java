// Copyright (c) 2018 Travelex Ltd

package BookApp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Author {

    private String name;
    private Date dob;
    private String penName;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public Author(String name, Date dob, String penName) {
        this.name = name;
        this.dob = dob;
        this.penName = penName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(String dobStr) {

        DateFormat format = new SimpleDateFormat("dd, mm, yyyy");

        Date dob;

        {
            try {
                dob = format.parse(dobStr);
                this.dob = dob;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

}
