import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Yansoul
 * @date 2022/5/8 - 15:15
 * 人生到处知何似，应似飞鸿踏雪泥
 */
@SpringBootApplication
@ComponentScan("com.course")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
