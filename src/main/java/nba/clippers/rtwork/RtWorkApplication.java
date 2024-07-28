package nba.clippers.rtwork;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("nba.clippers.rtwork.db.mapper")
@SpringBootApplication
public class RtWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtWorkApplication.class, args);
    }

}
