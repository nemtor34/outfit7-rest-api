package com.fun7.backend.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("bilbo123", "Bilbo", "Baggins", "bilbo.baggins@gmail.com")));
      log.info("Preloading " + repository.save(new User("frodo", "Frodo", "Baggins", "frodo.baggins@gmail.com")));
      log.info("Preloading " + repository.save(new User("legolas", "Legolas", "Green", "legolasg@gmail.com")));
      log.info("Preloading " + repository.save(new User("user4", "Anon4", "Lastname", "ano4@gmail.com")));
      log.info("Preloading " + repository.save(new User("user5", "Anon5", "Lastname", "ano5@gmail.com")));
      log.info("Preloading " + repository.save(new User("user6", "Anon6", "Lastname", "ano6@gmail.com")));
      log.info("Preloading " + repository.save(new User("user7", "Anon7", "Lastname", "ano7@gmail.com")));
      log.info("Preloading " + repository.save(new User("user8", "Anon8", "Lastname", "ano8@gmail.com")));
      log.info("Preloading " + repository.save(new User("user9", "Anon9", "Lastname", "ano9@gmail.com")));
      log.info("Preloading " + repository.save(new User("user10", "Anon10", "Lastname", "ano10@gmail.com")));
    };
  }
}
