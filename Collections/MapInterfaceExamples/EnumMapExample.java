package Collections.MapInterfaceExamples;

// It is more simple that HashMap
// It uses fixed size of array as Enum size
// here no hashing required
// it uses ordinal / index
// faster and memory efficient than HashMap

import java.util.EnumMap;

enum Days {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

public class EnumMapExample {
    public static void main(String[] args) {
        EnumMap<Days, String> map = new EnumMap<>(Days.class);
        map.put(Days.SUNDAY, "Chill");
        map.put(Days.SATURDAY, "WeekEnd");
        map.put(Days.MONDAY, "Work Started");
        System.out.println(map);
    }
}
