//package io.github.dami;
//
//import org.flywaydb.core.Flyway;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CleanDatabase implements ApplicationRunner {
//
//    @Autowired
//    private Flyway flyway;
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        flyway.clean();
//        flyway.migrate();
//    }
//
//}