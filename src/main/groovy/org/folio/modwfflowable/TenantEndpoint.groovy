package com.baeldung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.flowable.engine.impl.cfg.multitenant.MultiSchemaMultiTenantProcessEngineConfiguration;

@RestController
public class TenantController {

    @Autowired
    MultiSchemaMultiTenantProcessEngineConfiguration processEngineConfiguration;

    @GetMapping("/tenant")
    public String tenant() {
      println("Tenant post mapping");

      // as per https://blog.flowable.org/2018/09/11/multitenancy-in-flowable/
      // processEngineConfiguration.registerTenant("new-tenant", createDataSource("jdbc:h2:mem:flowable-new-tenant;DB_CLOSE_DELAY=1000", "sa", ""));
      return "Hello"
    }
  
}
