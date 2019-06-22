package org.folio.modwfflowable

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.flowable.spring.SpringProcessEngineConfiguration;
import org.flowable.spring.boot.EngineConfigurationConfigurer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
class ModWfFlowableApplication {

  static void main(String[] args) {
    SpringApplication.run(ModWfFlowableApplication, args)
  }

  // @Bean
  // public EngineConfigurationConfigurer<SpringProcessEngineConfiguration> customProcessEngineConfigurer() {
  //   return engineConfiguration -> {
  //     engineConfiguration.setValidateFlowable5EntitiesEnabled(false);
  //   };
  // }
}
