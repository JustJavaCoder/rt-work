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
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private static String filePath = "C:\\Users\\Russelltong\\Desktop\\";

    private static String templateFilePath = "src/main/resources/templates/";

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
            System.out.println(student.getId() + student.getName());
        });

        insertStuList(studentList);
    }


    private void insertStuList(List<Student> studentList) {

        System.out.println("进入insertStuList 开始准备插入");

        studentList.stream().forEach(student -> {

            studentMapper.insert(student);

        });


    }


    @Override
    public ResponseEntity<byte[]> downloadTemplate() throws IOException {
        // 模板文件路径
        String templateFilePath = "templates/studentTemplate.xlsx";

        // 读取模板文件
        ClassPathResource classPathResource = new ClassPathResource(templateFilePath);
        InputStream inputStream = classPathResource.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            byteArrayOutputStream.write(buffer, 0, bytesRead);
        }

        byte[] fileContent = byteArrayOutputStream.toByteArray();
        inputStream.close();
        byteArrayOutputStream.close();

        // 创建响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=studentTemplate.xls");

        // 返回文件内容
        return ResponseEntity.ok()
                .headers(headers)
                .body(fileContent);
    }
}
