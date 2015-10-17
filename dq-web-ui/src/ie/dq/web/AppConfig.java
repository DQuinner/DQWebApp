package ie.dq.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("ie.dq.*")
@Import({ MvcConfig.class, SecurityConfig.class })
public class AppConfig {

}
