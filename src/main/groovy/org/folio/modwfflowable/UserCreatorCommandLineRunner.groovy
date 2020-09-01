package org.folio.modwfflowable;

import org.flowable.idm.api.IdmIdentityService;
import org.flowable.idm.api.Privilege;
import org.flowable.idm.api.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserCreatorCommandLineRunner implements CommandLineRunner {

  Logger logger = LoggerFactory.getLogger(UserCreatorCommandLineRunner.class);

  protected final IdmIdentityService idmIdentityService;

  public UserCreatorCommandLineRunner(IdmIdentityService idmIdentityService) {
    this.idmIdentityService = idmIdentityService;
  }

  @Override
  public void run(String... args) {
    println("Create users.....");

    if (idmIdentityService.createPrivilegeQuery().privilegeName("ROLE_REST").count() == 0) {
      Privilege restPrivilege = idmIdentityService.createPrivilege("ROLE_REST");
    }

    if (idmIdentityService.createPrivilegeQuery().privilegeName("ROLE_ACTUATOR").count() == 0) {
      Privilege restPrivilege = idmIdentityService.createPrivilege("ROLE_ACTUATOR");
    }

    createUserIfNotExists("admin");
  }

  protected void createUserIfNotExists(String username) {
    println("createUserIfNotExists(${username})");

    if (idmIdentityService.createUserQuery().userId(username).count() == 0) {
      User user = idmIdentityService.newUser(username);
      user.setPassword("test");
      idmIdentityService.saveUser(user);

      def rest_priv = idmIdentityService.createPrivilegeQuery().privilegeName("ROLE_REST").singleResult()
      idmIdentityService.addUserPrivilegeMapping(rest_priv.getId(), username);
      def actuator_priv = idmIdentityService.createPrivilegeQuery().privilegeName("ROLE_ACTUATOR").singleResult()
      idmIdentityService.addUserPrivilegeMapping(actuator_priv.getId(), username);
    }
  }
}

