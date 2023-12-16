import java.util.*;

/**
 * The {@code Student} class represents a student with a name, GPA, and ID.
 */
class Student {
    private int id;
    private String name;
    private double gpa;

    /**
     * Constructs a new Student object.
     *
     * @param name The name of the student.
     * @param gpa  The GPA of the student.
     * @param id   The ID of the student.
     */
    public Student(String name, double gpa, int id) {
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    /**
     * Gets the ID of the student.
     *
     * @return The ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the student.
     *
     * @return The name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the GPA of the student.
     *
     * @return The GPA.
     */
    public double getGpa() {
        return gpa;
    }
}

/**
 * The {@code StudentComparator} class is a comparator for comparing students based on GPA, name, and ID.
 */
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        int cgpa = Double.compare(y.getGpa(), x.getGpa());
        if (cgpa != 0) {
            return cgpa;
        }

        int cname = x.getName().compareTo(y.getName());
        if (cname != 0) {
            return cname;
        }

        return Integer.compare(x.getId(), y.getId());
    }
}

/**
 * The {@code StudentPrioritizer} class manages students using a PriorityQueue.
 */
class StudentPrioritizer {
    /**
     * Gets the list of students based on a series of events.
     *
     * @param events The list of events.
     * @return The list of students after processing the events.
     */
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(new StudentComparator());
        List<Student> result = new ArrayList<>();

        for (String event : events) {
            if (event.equals("SERVED")) {
                if (!studentQueue.isEmpty()) {
                    studentQueue.poll();
                }
            } else {
                String[] parts = event.split(" ");
                studentQueue.offer(new Student(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        }

        while (!studentQueue.isEmpty()) {
            result.add(studentQueue.poll());
        }

        return result;
    }
}

/**
 * The {@code JavaPriorityQueueApp} class is the main application class.
 */
public class JavaPriorityQueueApp {
    private final static Scanner scanner = new Scanner(System.in);
    private final static StudentPrioritizer studentPrioritizer = new StudentPrioritizer();

    /**
     * The main entry point for the application.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            events.add(scanner.nextLine());
        }

        List<Student> students = studentPrioritizer.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.forEach(student -> System.out.println(student.getName()));
        }
    }
}
