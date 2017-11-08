package alvarez.oscar.diwithdagger2.modules;

import java.util.ArrayList;
import java.util.List;

import alvarez.oscar.diwithdagger2.models.Student;
import alvarez.oscar.diwithdagger2.models.Group;
import alvarez.oscar.diwithdagger2.models.Teacher;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Oscar Álvarez on 05/11/17.
 */

@Module
public class MathGroupModule {

    @Provides
    List<Student> providesMathStudents() {
        List<Student> mathStudents = new ArrayList<>();
        Student s1 = new Student("SName 1", "SLastname 1");
        Student s3 = new Student("SName 3", "SLastname 3");
        Student s5 = new Student("SName 5", "SLastname 5");
        mathStudents.add(s1);
        mathStudents.add(s3);
        mathStudents.add(s5);
        return mathStudents;
    }

    @Provides
    Teacher providesMathTeacher() {
        return new Teacher("TName 1", "Maths");
    }

    //use of providers as method parameters
    @Provides
    Group providesMathGroup(Teacher teacher, List<Student> mStudents) {
        return new Group(teacher, mStudents);
    }
}
