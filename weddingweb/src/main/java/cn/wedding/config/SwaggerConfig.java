package cn.wedding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //名称
                .groupName("yhj")
                .select()
                //要扫描的包
                .apis(RequestHandlerSelectors.basePackage("cn.wedding.controller"))
                .build();
    }
    //配置Swagger 信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("西工大鹏飞小组", "", "");

        return new ApiInfo(
                "Api Documentation" //标题名
                , "Api Documentation" //描述信息
                , "1.0"
                , "urn:tos"
                , contact
                , "Apache 2.0"
                , "http://www.apache.org/licenses/LICENSE-2.0"
                , new ArrayList());
    }
}
