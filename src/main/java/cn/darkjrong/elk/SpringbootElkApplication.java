package cn.darkjrong.elk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringbootElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElkApplication.class, args);
    }

}
