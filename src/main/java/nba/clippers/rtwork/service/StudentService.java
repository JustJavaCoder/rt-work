package nba.clippers.rtwork.service;

import nba.clippers.rtwork.db.entity.Student;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;


public interface StudentService {

    List<Student> selectStuList();

    void stuListExport();

    void stuListImport();

    ResponseEntity<byte[]> downloadTemplate() throws IOException;
}
