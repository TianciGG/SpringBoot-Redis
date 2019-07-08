package chauncy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@EnableAutoConfiguration
@ComponentScan(value="chauncy.*")
public class APP {
	
	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}
