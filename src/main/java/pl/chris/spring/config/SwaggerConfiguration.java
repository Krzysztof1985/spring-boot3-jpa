package pl.chris.spring.config;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket dockerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.springframework.boot")
                        .negate())
                .build()
                .consumes(Set.of(APPLICATION_JSON_VALUE))
                .produces(Set.of(APPLICATION_JSON_VALUE));
    }

    @Bean
    public OpenAPI customApi() {
        return new OpenAPI()
                .info(new Info().title("Specification API")
                        .version("1.0")
                        .description("Example usage of Specification API")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")));

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Specification API Example")
                .version("1.0")
                .build();
    }
}
