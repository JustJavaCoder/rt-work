package nba.clippers.rtwork;

import nba.clippers.rtwork.db.entity.Student;
import nba.clippers.rtwork.db.mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RtWorkApplicationTests {

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void testExport() {
        Student student = new Student();
        List<Student> studentList = student.getStudentList();

       studentList.stream().forEach(student1 ->{
        studentMapper.insert(student1);

       });

    }

}
