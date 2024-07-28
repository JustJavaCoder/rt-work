package nba.clippers.rtwork.service.impl;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.SneakyThrows;
import nba.clippers.rtwork.db.entity.Student;
import nba.clippers.rtwork.db.mapper.StudentMapper;
import nba.clippers.rtwork.service.StudentService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static String filePath = "C:\\Users\\Russelltong\\Desktop\\";

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> selectStuList() {

        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();

        QueryWrapper<Student> wrapper = studentQueryWrapper.isNotNull("name");
        // 查出来所有名字不为空的学生数据
        List<Student> studentList = studentMapper.selectList(wrapper);

        return studentList;

    }

    @SneakyThrows
    @Override
    public void stuListExport() {

        //     执行学生列表输出
        ExportParams exportParams = new ExportParams("学生列表", "测试数据sheetName");

        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, Student.class, selectStuList());

        FileOutputStream out = new FileOutputStream(filePath + "studentList.xls");

        workbook.write(out);

        out.close();

        workbook.close();

        System.out.println("导出成功");
    }


    @Override
    public void stuListImport() {

        ImportParams importParams = new ImportParams();

        // importParams.setHeadRows(1);
        importParams.setTitleRows(1);


        FileInputStream in = null;
        try {
            in = new FileInputStream(filePath + "studentList.xls");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        List<Student> studentList = null;
        try {
            studentList = ExcelImportUtil.importExcel(in, Student.class, importParams);
        } catch (Exception e) {

        }

        // 测试studentlist里边有数据没
        System.out.println("打印一下studentlsit");
        studentList.stream().forEach(student -> {
            System.out.println(student.getId()+student.getName());
        });

        insertStuList(studentList);
    }

    private void insertStuList(List<Student> studentList) {

        System.out.println("进入insertStuList 开始准备插入");

        studentList.stream().forEach(student -> {

            studentMapper.insert(student);

        });


    }
}
