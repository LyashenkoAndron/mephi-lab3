package model;

public class Info {
    private String name;
    private String email;
    private String adress;

    public Info(String name, String email, String adress) {
        this.name = name;
        this.email = email;
        this.adress = adress;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
