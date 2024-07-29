// package nba.clippers.rtwork.config;
//
// import io.swagger.v3.oas.models.OpenAPI;
// import io.swagger.v3.oas.models.info.Contact;
// import io.swagger.v3.oas.models.info.Info;
// import io.swagger.v3.oas.models.info.License;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// // import springfox.documentation.spring.web.plugins.Docket;
// // import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
// @Configuration
// // @EnableSwagger2
// public class SwaggerConfig {
//
//
//     /*
//      * Docket类是swagger的配置类
//      * 要自定义的修改swagger的默认配置信息 我们需要覆盖该对象
//      * */
//     // @Bean
//     // public Docket docket(){
//     //
//     //
//     //     return null;
//     // }
//
//
//     /*改用springdoc-openapi*/
//     @Bean
//     public OpenAPI openAPI() {
//
//         // return new OpenAPI().info(new Info().version("1.0").title("my api").contact(new Contact().name("russell").email("russelltong0@163.com")));
//
//         return new OpenAPI()
//                 .info(new Info()
//                         .title("My API")
//                         .version("1.0")
//                         .description("This is a sample Spring Boot RESTful service using Springdoc OpenAPI")
//                         .termsOfService("http://example.com/terms/")
//                         .contact(new Contact()
//                                 .name("John Doe")
//                                 .url("http://example.com/contact")
//                                 .email("contact@example.com"))
//                         .license(new License()
//                                 .name("Apache 2.0")
//                                 .url("http://springdoc.org")));
//     }
// }
//
//
//
//
