package org.folio.modwfflowable

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


// @ComponentScan(basePackages = "org.flowable.rest.service.api")
// @ComponentScan("org.flowable")
// @SpringBootApplication(scanBasePackages = { "org.flowable",...} )
// https://flowable.com/open-source/docs/bpmn/ch15-REST/


@SpringBootApplication(scanBasePackages = "org.flowable.rest.service.api")
class ModWfFlowableApplication {

  static void main(String[] args) {
    SpringApplication.run(ModWfFlowableApplication, args)
  }

  @Bean
  public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customProcessEngineConfigurer() {
    // implement interface https://github.com/flowable/flowable-engine/blob/master/modules/flowable-spring-boot/flowable-spring-boot-starters/flowable-spring-boot-autoconfigure/src/main/java/org/flowable/spring/boot/EngineConfigurationConfigurer.java
    //
    return { SpringProcessEngineConfiguration engineConfiguration ->
      engineConfiguration.setValidateFlowable5EntitiesEnabled(false);
    } as EngineConfigurationConfigurer<SpringProcessEngineConfiguration>;
  }
}
