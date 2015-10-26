package ie.dq;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ie.dq.DaoConfig;

@Configuration
@Import({ DaoConfig.class})
public class ServiceConfig {

}
