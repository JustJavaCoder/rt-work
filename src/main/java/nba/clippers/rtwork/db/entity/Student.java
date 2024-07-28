package nba.clippers.rtwork.db.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("students")
@TableName("student_info")
public class Student implements Serializable {


    @Excel(name = "序号")
    @TableId(type = IdType.AUTO)
    private int id;

    @Excel(name = "姓名")
    private String name;

    @Excel(name = "身高")
    private Double height;

    @Excel(name = "性别", replace = {"男_1", "女_0"})
    private String sex;

    @Excel(name = "学号")
    private Long stuNum;

    @Excel(name = "学院")
    private String dept;

    @Excel(name = "专业")
    private String profession;

    @Excel(name = "生日", format = "yyyy-MMMM-dddd HH-mm-SS")
    private Date bir;

    @Excel(name = "学校名称")
    private String college;

    @Excel(name = "绩点")
    @TableField("GPA")
    private Float GPA;

    @Excel(name = "银行卡")
    private Long bankCardNum;

    @Excel(name = "身份证号")
    private Long idCardNum;

    @Excel(name = "是否是贫困生", replace = {"是_1", "不是_0"})
    @TableField("is_poor_student")
    private int poorStu;

    @Excel(name = "是否是优秀学生", replace = {"是_1", "不是_0"})
    @TableField("is_excellent_student")
    private int execellentStu;

    public List<Student> getStudentList() {
        ArrayList<Student> students = new ArrayList<>();


        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setName("贾旭彤");
            student.setBir(new Date());
            student.setSex("1");
            student.setGPA(new Random(4).nextFloat());
            // student.setId("18L05-7" + i);
            student.setPoorStu(1);
            student.setExecellentStu(1);

            students.add(student);
        }

        return students;
    }

}
