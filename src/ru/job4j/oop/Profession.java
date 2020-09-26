package ru.job4j.oop;

import java.time.LocalDate;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}

class Doctor extends Profession {
    public Diagnosis heal(Patient patient) {
        return null;
    }
}

class Engineer extends Profession {

}

class Surgeon extends Doctor { }

class Dentist extends Doctor { }

class Programmer extends Engineer { }

class Builder extends Engineer { }

class Patient { }

class Diagnosis { }


