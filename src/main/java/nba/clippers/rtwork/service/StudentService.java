package nba.clippers.rtwork.service;

import nba.clippers.rtwork.db.entity.Student;

import java.util.List;


public interface StudentService {

    List<Student> selectStuList();

    void stuListExport();

    void stuListImport();
}
