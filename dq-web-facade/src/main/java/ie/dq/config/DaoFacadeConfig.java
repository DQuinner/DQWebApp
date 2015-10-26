package ie.dq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dao")
@ComponentScan({"ie.dq.web.facade","ie.dq.dao"})
public class DaoFacadeConfig {

}
