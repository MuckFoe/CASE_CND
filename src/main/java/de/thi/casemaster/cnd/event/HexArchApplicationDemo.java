package de.thi.casemaster.cnd.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class HexArchApplicationDemo {

    public static void main(String[] args) {
        SpringApplication.run(HexArchApplicationDemo.class, args);
    }

}
