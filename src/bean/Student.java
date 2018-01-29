package bean;

public class Student implements Comparable<Student> {
    private String name;
    private int score;

    @Override
    public int compareTo(Student o) {
        return this.score > o.score ? 1 : this.score == o.score ? 0 : -1;
    }
}
