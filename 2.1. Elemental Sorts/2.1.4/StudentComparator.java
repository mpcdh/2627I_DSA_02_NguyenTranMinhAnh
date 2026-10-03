import java.util.*;

public class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        if (x.getCGPA() > y.getCGPA()) {
            return 1;
        } else if (x.getCGPA() == y.getCGPA() && x.getName().compareTo(y.getName()) < 0) {
            return 1;
        } else if (x.getCGPA() == y.getCGPA() && x.getName().equals(y.getName()) && x.getId() < y.getId()) {
            return 1;
        } else {
            return -1;
        }
    }

    public void selectionSort(List<Student> students) {
        for (int i = 0; i < students.size() - 1; i++) {
            Student student = students.get(i);
            int idx = i;
            for (int j = i + 1; j < students.size(); j++) {
                if (compare(student, students.get(j)) < 0) {
                    student = students.get(j);
                    idx = j;
                }
            }
            Student tmp = students.get(i);
            students.set(i, student);
            students.set(idx, tmp);
        }
    }

    public void printNameArray(List<Student> students) {
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String student = scanner.nextLine();
            String[] attributes = student.split(" ");
            Student new_student = new Student(Integer.parseInt(attributes[0]), attributes[1], Double.parseDouble(attributes[2]));
            students.add(new_student);
        }

        StudentComparator comparator = new StudentComparator();
        // comparator.selectionSort(students);
        students.sort(comparator);
        Collections.reverse(students);
        comparator.printNameArray(students);
    }
}
