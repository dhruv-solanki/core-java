package Collections.ListInterfaceExamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// o = o1 - o2, this will sort in ASC order
// o = o2 - o1, this will sort in DESC order
class IntegerComparator implements Comparator<Integer> {
//    if o is negative means o1 comes first and o2 comes second
//    if o is zero means o1 and o2 are equal
//    if o is positive means o1 comes second and o2 comes first
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}

// same logic as above but we just used string length
// s = s1.length() - s2.length(), so it will sort in ASC order of string length
// s = s2.length() - s1.length(), it will sort in DESC order of string length
class StringLengthComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}

class Student {
    private String name;
    private double gpa;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        Integer[] array = {3, 2, 1, 6, 5, 4};
        List<Integer> intList = new ArrayList<>(Arrays.asList(array));
//        default asc sorting
//        intList.sort(null);
        intList.sort(new IntegerComparator());
        System.out.println(intList);

        String[] strArray = {"Captain", "America", "Ironman", "Thor", "Spiderman"};
        List<String> strList = new ArrayList<>(Arrays.asList(strArray));
//        we are sorting by string length in ASC order
        strList.sort(new StringLengthComparator());
        System.out.println(strList);

//        we can also use lambda expression since comparator interface is FunctionalInterface
//        it will sort by string length in DESC order
        strList.sort((a, b) -> b.length() - a.length());
        System.out.println(strList);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Rahul", 4.30));
        students.add(new Student("Dhruv", 4.30));
        students.add(new Student("Nirav", 3.9));
        students.add(new Student("James", 3.7));
        students.add(new Student("Kylie", 2.5));

//        students.sort((a, b) -> {
//            if(a.getGpa() - b.getGpa() > 0) {
//                return 1;
//            } else if (a.getGpa() - b.getGpa() < 0) {
//                return -1;
//            } else {
//                return 0;
//            }
//        });

//        here :: is giving the function reference and then we are doing functional chaining
        Comparator<Student> comparator = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);
        students.sort(comparator);

        for(Student s: students) {
            System.out.println(s.getName() + ": " + s.getGpa());
        }
    }
}
