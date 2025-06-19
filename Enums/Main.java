package Enums;

public class Main {
    public static void main(String[] args) {
        System.out.println(Days.MONDAY);
        for(Days day: Days.values()) {
            System.out.println(day.ordinal() + 1 + " : " + day.name());
        }

        Days.FRIDAY.display();

        Days newDay = Days.SUNDAY;

        switch(newDay) {
            case Days.MONDAY: {
                System.out.println("Time to start your work");
                break;
            }
            case Days.SATURDAY: {
                System.out.println("Weekend started, let's plan!");
                break;
            }
            case Days.SUNDAY: {
                System.out.println("Time to chill and relax!");
                break;
            }
        }
    }
}
