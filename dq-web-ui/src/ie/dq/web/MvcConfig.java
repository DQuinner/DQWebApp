package ie.dq.web;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import ie.dq.config.DaoFacadeConfig;
import ie.dq.config.StubFacadeConfig;

@Configuration
@EnableWebMvc
@Import({DaoFacadeConfig.class, StubFacadeConfig.class})
public class MvcConfig extends WebMvcConfigurerAdapter {

	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/css/**").addResourceLocations("/WEB-INF/css/");
	    registry.addResourceHandler("/js/**").addResourceLocations("/WEB-INF/js/");
	    registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image/");
	    registry.addResourceHandler("/fonts/**").addResourceLocations("/WEB-INF/fonts/"); 
	 }

	/**
	 * Establish a ViewResolver that adds a prefix / suffix to 
	 * the logical view name and selects the JstlView for rendering.
	 */
	@Bean
	public ViewResolver irvr(){
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/jsp/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
	@Bean 
	public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
		SimpleMappingExceptionResolver er=new SimpleMappingExceptionResolver();
		er.setDefaultErrorView("error");
		Properties mappings=new Properties();
		mappings.put("ie.dq.web.exception.UserFormException","userFormException");
		mappings.put(".DataAccessException","dataAccessFailure");
		mappings.put(".NoSuchRequestHandlingMethodException","resourceNotFound");
		mappings.put(".TypeMismatchException","resourceNotFound");
		mappings.put(".MissingServletRequestParameterException","resourceNotFound");
		er.setExceptionMappings(mappings);
		return er;
	}
		
}
