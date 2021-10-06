package org.techtown.listviewcheckbox;

public class Student {
    private String id;
    private String name;
    private String sexString;
    private boolean state;

    public Student(String id, String name, String sexString, boolean state) {
        super();
        this.id = id;
        this.name = name;
        this.sexString = sexString;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSexString() {
        return sexString;
    }

    public void setSexString(String sexString) {
        this.sexString = sexString;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

}
