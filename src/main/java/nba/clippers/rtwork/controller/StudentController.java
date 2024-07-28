package nba.clippers.rtwork.controller;

import nba.clippers.rtwork.db.entity.Student;
import nba.clippers.rtwork.db.mapper.StudentMapper;
import nba.clippers.rtwork.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("stu/")
public class StudentController {

    @Autowired
    StudentService studentService;


    /*
     * 写一个简单的导出方法
     * */
    @GetMapping("export")
    public void stuExport() {
        //    在controller层只执行一个导出方法

       studentService.stuListExport();


    }

    /*
    * 一个简单的导入方法
    * */
    @GetMapping("import")
    public void stuImport(){
        studentService.stuListImport();
        System.out.println("导出成功");
    }



}
