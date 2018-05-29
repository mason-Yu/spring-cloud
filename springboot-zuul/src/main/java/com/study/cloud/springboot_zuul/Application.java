package com.study.cloud.springboot_zuul;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import com.spring4all.swagger.EnableSwagger2Doc;
import com.study.cloud.filter.AccessFilter;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@EnableSwagger2Doc
@EnableZuulProxy
@SpringCloudApplication
public class Application {

  public static void main(String[] args) {
    new SpringApplicationBuilder(Application.class).web(true).run(args);
  }

  @Bean
  public AccessFilter accessFilter() {
    return new AccessFilter();
  }

  @Component
  @Primary
  class DocumentationConfig implements SwaggerResourcesProvider {

    @Override
    public List<SwaggerResource> get() {
      List resources = new ArrayList<>();
      resources.add(SwaggerResource("user-service", "/user-service/v2/api-docs", "2.0"));
      return resources;
    }

    private SwaggerResource SwaggerResource(String name, String location, String version) {
      SwaggerResource sr = new SwaggerResource();
      sr.setName(name);
      sr.setLocation(location);
      sr.setSwaggerVersion(version);
      return sr;
    }
  }
}
