package com.example.hellobank_ibm.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.hellobank_ibm"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(metaInfo());
	}

	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo("[IBM- If Black, Then Code]  - API REST", "Desafio Final - Projeto Hello Bank",
				"1.0", "Termos de Serviço",
				new Contact("Guilherme Barros, Jokebede Coimbra, Lucas Pontes, Tobias Gustavo",
						"https://github.com/Lucas-P0ntes/Hello_Bank_ibm", ""),
				"Apache License Version 2.0", "http://www.apache.org/license.html", new ArrayList<VendorExtension>());
		return apiInfo;
	}

}
