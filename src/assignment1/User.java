package assignment1;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by Nick Pierre on 8/21/2016.
 */
public class User {
    private String gender;
    private String firstName;
    private String lastName;
    private DatePicker dp; // String in form of Month-Date-Year

    public User(String gender, String firstName, String lastName, DatePicker dp) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dp = dp;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDOB(DatePicker dp) {
        this.dp = dp;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public DatePicker getDOB() {
        return dp;
    }

    public int getAge() {
        LocalDate date = getDOB().getValue();
        return Calendar.YEAR - date.getYear();
    }

    @Override
    public String toString(){
        return "First Name: " + getFirstName() +
                "\nLast Name: " + getLastName() +
                "\nGender: " + getGender() +
                "\nDOB: " + getDOB() +
                "\nAge: " + getAge();

    }
}
