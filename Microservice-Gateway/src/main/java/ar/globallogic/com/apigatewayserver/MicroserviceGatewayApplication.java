package ar.globallogic.com.apigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import ar.globallogic.com.filterapigateway.ErrorFilter;
import ar.globallogic.com.filterapigateway.PostFilter;
import ar.globallogic.com.filterapigateway.PreFilter;
import ar.globallogic.com.filterapigateway.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
public class MicroserviceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceGatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public RouteFilter routerFilter() {
		return new RouteFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

}
