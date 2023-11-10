package io.github.medeirosavio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements Ordered {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("io.github.medeirosavio"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Brasil Saude API")
                .description("O Ministério da Saúde necessita criar um sistema web para " +
                        "monitoramento dos casos de COVID-19 no Brasil. O sistema deve fornecer " +
                        "informações referentes ao número de casos confirmados, óbitos confirmados," +
                        " casos recuperados e hospitalizações. Além disso, o sistema deve fornecer relatórios " +
                        "a partir de análises descritivas dos dados, considerando faixa etária, sexo, região," +
                        " intensidade dos sintomas, etc. O objetivo do sistema é fornecer um veículo oficial de " +
                        "comunicação sobre a situação epidemiológica da COVID-19 no Brasil.")
                .version("1.0.0")
                .build();
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
