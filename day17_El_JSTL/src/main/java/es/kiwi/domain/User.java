package es.kiwi.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age, Date bir) {
        this.name = name;
        this.age = age;
        this.bir = bir;
    }

    private Date bir;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBir() {
        return bir;
    }

    /**
     * 逻辑视图
     * @return
     */
    public String getBirStr() {
        if (bir != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(bir);
        }
        return "";
    }

    public void setBir(Date bir) {
        this.bir = bir;
    }
}
