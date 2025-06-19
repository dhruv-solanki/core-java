package Enums;

public enum Days {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private Days(String lower) {
        System.out.println("Lower constructor called!");
        this.lower = lower;
    }

    private String lower;

    public void display() {
        System.out.println("Today is " + this.lower);
    }
}
