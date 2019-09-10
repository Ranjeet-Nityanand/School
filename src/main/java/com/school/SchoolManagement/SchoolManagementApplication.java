package com.school.SchoolManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.school.SchoolManagement.utility.ImageServlet;

@SpringBootApplication
public class SchoolManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolManagementApplication.class, args);
	}

	

	@Bean
	public ServletRegistrationBean resgister() {
		
		ServletRegistrationBean servelet=new ServletRegistrationBean();
		servelet.addUrlMappings("/view-students/**");
		servelet.setServlet(new ImageServlet());
		
		return servelet;
	}
}
