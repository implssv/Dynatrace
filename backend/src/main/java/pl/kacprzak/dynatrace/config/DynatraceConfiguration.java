package pl.kacprzak.dynatrace.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.kacprzak.dynatrace.exception.handler.RequestErrorHandler;


@Configuration
public class DynatraceConfiguration {


    @Value("${dynatrace.login}")
    private String login;
    @Value("${dynatrace.password}")
    private String password;
    @Value("${dynatrace.url.base}")
    private String baseUrl;



    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder)
    {
        return builder.basicAuthorization(login,password).rootUri(baseUrl).errorHandler(new RequestErrorHandler()).build();

    }

}
