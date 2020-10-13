package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFIO("Maksyutov S.H.");
        student.setGroup("101");
        student.setPostuplenie(new Date());
        System.out.println(student.getFIO() + ": group " + student.getGroup() + ", postuplenie " + student.getPostuplenie());
    }
}
