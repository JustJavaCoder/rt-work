// package nba.clippers.rtwork;
//
// import com.auth0.jwt.JWT;
// import com.auth0.jwt.JWTVerifier;
// import com.auth0.jwt.algorithms.Algorithm;
// import com.auth0.jwt.interfaces.Claim;
// import com.auth0.jwt.interfaces.DecodedJWT;
// import nba.clippers.rtwork.db.entity.Student;
// import nba.clippers.rtwork.db.mapper.StudentMapper;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
//
// import java.util.Calendar;
// import java.util.HashMap;
// import java.util.List;
//
//
// @RunWith(SpringRunner.class)
// @SpringBootTest
// public class RtWorkApplicationTests {
//
//     @Autowired
//     StudentMapper studentMapper;
//
//     @Test
//     public void testExport() {
//         Student student = new Student();
//         List<Student> studentList = student.getStudentList();
//
//        studentList.stream().forEach(student1 ->{
//         studentMapper.insert(student1);
//
//        });
//
//     }
//
//
//     @Test
//     public void genetateJWTtoken(){
//         Calendar calendar = Calendar.getInstance();
//         calendar.add(Calendar.SECOND,10);
//
//         String token = JWT.create().withHeader(new HashMap<>()) //header
//                 .withClaim("userId", 21) //payload
//                 .withClaim("userName", "russ")
//                 .withExpiresAt(calendar.getTime())
//                 .sign(Algorithm.HMAC256("!34adas"));
//
//         System.out.println("calendar = " + calendar);
//         System.out.println(token);
//     }
//
//     @Test
//     public void resolveJTWtoken(){
//         JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("!34ADAS")).build();
//         DecodedJWT verify = jwtVerifier
//                 .verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6InJ1c3MiLCJleHAiOjE3MjIzMzUwODQsInVzZXJJZCI6MjF9.hcG8J5B-oezc53YYggtxVbOCluCFbr6VXFz9VWyzMMw");
//         Claim userId = verify.getClaim("userId");
//         Claim userName = verify.getClaim("userName");
//         System.out.println("userId.asInt() = " + userId.asInt());
//         System.out.println("userName.asString() = " + userName.asString());
//         System.out.println("verify.getExpiresAt() = " + verify.getExpiresAt());
//     }
// }
