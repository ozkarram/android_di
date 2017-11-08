package alvarez.oscar.diwithdagger2.models;

import java.util.List;

/**
 * Created by Oscar Álvarez on 04/11/17.
 */

public class Group {
    Teacher teacher;
    List<Student> students;
    public Group(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
}
