package alvarez.oscar.diwithdagger2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import alvarez.oscar.diwithdagger2.components.DaggerGeneralComponent;
import alvarez.oscar.diwithdagger2.models.Group;
import alvarez.oscar.diwithdagger2.models.Student;
import alvarez.oscar.diwithdagger2.models.School;
import alvarez.oscar.diwithdagger2.models.Teacher;

public class MainActivity extends AppCompatActivity {

    @Inject
    Group group;

    @Inject
    Teacher teacher;

    @Inject
    List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerGeneralComponent.builder().build().inject(this);

        //generate school
        Teacher tMat = new Teacher("TName 1", "Maths");
        Teacher tGeog = new Teacher("TName 2", "Geography");
        Teacher tHist = new Teacher("TName 3", "History");
        Teacher tEng = new Teacher("TName 4", "English");

        Student s1 = new Student("SName 1", "SLastname 1");
        Student s2 = new Student("SName 2", "SLastname 2");
        Student s3 = new Student("SName 3", "SLastname 3");
        Student s4 = new Student("SName 4", "SLastname 4");
        Student s5 = new Student("SName 5", "SLastname 5");
        Student s6 = new Student("SName 6", "SLastname 6");

        List<Student> mathStudents = new ArrayList<>();
        List<Student> geoStudents = new ArrayList<>();
        List<Student> histStudents = new ArrayList<>();
        List<Student> engStudents = new ArrayList<>();

        mathStudents.add(s1);
        mathStudents.add(s3);
        mathStudents.add(s5);

        geoStudents.add(s2);
        geoStudents.add(s4);
        geoStudents.add(s6);

        histStudents.add(s1);
        histStudents.add(s2);
        histStudents.add(s3);

        engStudents.add(s4);
        engStudents.add(s5);
        engStudents.add(s6);

        Group mathGroup = new Group(tMat, mathStudents);
        Group geoGroup = new Group(tGeog, geoStudents);
        Group histGroup = new Group(tHist, histStudents);
        Group engGroup = new Group(tEng, engStudents);

        List<Group> groups = new ArrayList<>();

        groups.add(mathGroup);
        groups.add(geoGroup);
        groups.add(histGroup);
        groups.add(engGroup);

        School school = new School(groups);

    }

    //manual providers
    Group providesMathGroup(List<Student> mStudents, Teacher mTeacher) {
        return new Group(mTeacher, mStudents);
    }

    List<Student> providesMathStudent() {
        List<Student> mathstudents = new ArrayList<>();
        Student s1 = new Student("SName 1", "SLastname 1");
        Student s3 = new Student("SName 3", "SLastname 3");
        Student s5 = new Student("SName 5", "SLastname 5");
        mathstudents.add(s1);
        mathstudents.add(s3);
        mathstudents.add(s5);
        return mathstudents;
    }

    Teacher providesMathTeacher() {
        return new Teacher("TName 1", "Maths");
    }

    Group providesMathGroup() {
        return providesMathGroup(providesMathStudent(), providesMathTeacher());
    }


}
