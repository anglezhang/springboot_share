package com.cn.model;

/**
 * ClassName: Child <br/>
 * Description: <br/>
 * date: 2021/7/26 21:14<br/>
 *
 * @author zhangzhenxing<br />
 */
public class Child {

    private String age;
    private String gender;
    private String tel;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Child{" +
                "age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
