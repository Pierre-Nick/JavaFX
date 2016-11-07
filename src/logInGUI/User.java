package logInGUI;

import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * Created by Nick Pierre on 8/21/2016.
 */
class User {
    private String gender;
    private String firstName;
    private String lastName;
    private DatePicker datePicker; // String in form of Month-Date-Year
    private LocalDate localDate;

    User(String gender, String firstName, String lastName, DatePicker dp) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.datePicker = dp;
        localDate = dp.getValue();
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDOB(DatePicker dp) {
        this.datePicker = dp;
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

    public LocalDate getDOB() {
        return localDate;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - localDate.getYear();
    }

    @Override
    public String toString(){
        return "First Name: " + getFirstName() +
                "\nLast Name: " + getLastName() +
                "\nGender: " + getGender() +
                "\nDOB: " + getDOB() +
                "\nEstimated Age: " + getAge();

    }
}
