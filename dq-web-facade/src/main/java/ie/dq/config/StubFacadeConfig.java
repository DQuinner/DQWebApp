package ie.dq.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("stub")
@ComponentScan("ie.dq.stub.facade.impl")
public class StubFacadeConfig {
	
}
