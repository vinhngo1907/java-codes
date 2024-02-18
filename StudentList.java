import java.util.*;

public class StudentList {
    private ArrayList<Student> list;
    private int length;

    public StudentList() {
        list = new ArrayList<Student>();
    }

    public ArrayList<Student> findByName(String name) {
        boolean found = false;
        ArrayList<Student> matches = new ArrayList<Student>();
        for (Student s : list) {
            String fullName = new String(s.getFirstName() + " " + s.getLastName()).toLowerCase();
            if (fullName.matches("(.*)" + name.toLowerCase() + "(.*)")) {
                matches.add(s);
                found = true;
            }
        }
        if (found == false) {
            System.out.println("Not found");
        }
        return matches;
    }

    public Student findById(int id) {
        for (Student s : list) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void add (Student s){
        list.add(s);
    }
}
