package ua.opnu;

class GenericTwoTuple<T, V> {

    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}

class GenericThreeTuple<T, V, S> extends GenericTwoTuple<T, V> {

    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ')';
    }
}

class Student {
    private String fullName;

    public Student(String fullName) {
        this.fullName = fullName;
    }

    public int calculateRating() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return fullName;
    }
}

class Course {
    private String name;
    private int credits;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    @Override
    public String toString() {
        return name + " (" + credits + " кредитів)";
    }
}