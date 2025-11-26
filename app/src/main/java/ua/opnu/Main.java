package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if (item.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ////////////////////////////// Завдання 1

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        ////////////////////////////// Завдання 2
        BookData book1 = new BookData("Test Book A", "Author", 10, 5.0);
        BookData book2 = new BookData("Test Book B", "Author", 10, 4.0);
        BookData book3 = new BookData("Another Book", "Author", 10, 5.0);

        System.out.println();
        System.out.println(book1.compareTo(book2));
        System.out.println(book2.compareTo(book1));
        System.out.println(book1.compareTo(book3));
        System.out.println(book3.compareTo(book1));

        ////////////////////////////// Завдання 3
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        System.out.println();
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        ////////////////////////////// Завдання 4
        String[] words = {"aaa", "bbb", "ccccccc", "ddd"};
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        System.out.println();

        System.out.println(Arrays.toString(filter(words, s -> s.length() > 5)));
        System.out.println(Arrays.toString(filter(numbers, n -> n % 2 == 0)));

        ////////////////////////////// Завдання 5
        String[] strings = {"aaa", "bbb", "ccc", "ddd"};
        Integer[] ints = {10, 5, 30, 8, 97};
        System.out.println();
        System.out.println(contains(strings, "aaa"));
        System.out.println(contains(strings, "eee"));
        System.out.println(contains(ints, 10));
        System.out.println(contains(ints, 58544));

        ////////////////////////////// Завдання 6
        GenericTwoTuple<Student, Integer> tuple1 = getStudentWithRating("Маєр Максим");
        System.out.println(tuple1);

        GenericTwoTuple<String, Double> tuple2 = new GenericTwoTuple<>("Чипси", 90.0);
        System.out.println(tuple2);

        GenericThreeTuple<Student, Course, String> tuple3 = getStudentCourseGrade("Дегтяренко Уляна", "Java");
        System.out.println(tuple3);

        GenericThreeTuple<String, String, Integer> tuple4 = new GenericThreeTuple<>("Сушені кальмари", "Своя лінія", 10);
        System.out.println(tuple4);
    }

    public static GenericTwoTuple<Student, Integer> getStudentWithRating(String fullName) {
        Student student = new Student(fullName);
        int rating = student.calculateRating();
        return new GenericTwoTuple<>(student, rating);
    }

    public static GenericThreeTuple<Student, Course, String> getStudentCourseGrade(String studentName, String courseName) {
        Student student = new Student(studentName);
        Course course = new Course(courseName, 5);
        String grade = "A";
        return new GenericThreeTuple<>(student, course, grade);
    }
}
