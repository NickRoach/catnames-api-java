package com.catnames.triggers;

import com.catnames.repositories.CatnamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;

public class CatnamesTrigger {

    @Autowired private CatnamesRepository catnamesRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @EventListener
    public void seed(ContextRefreshedEvent event) {

        //if there are one or more entries in the users table, no seeding will be executed
        int userCount = this.catnamesRepository.findAll().size();
        if (userCount != 0) {
            return;
        }

        //if the users table is empty, all of these seeding functions will be executed

        createTrigger("catnames");
        System.out.println("trigger thing was called");
    }



    private void createTrigger(String table) {
        // TODO: Add spring log output for trigger queries
        String triggerTemplate = """
            CREATE TRIGGER audit_record_trigger_%s BEFORE INSERT ON %s
            FOR EACH ROW BEGIN
              SET NEW.record_id = NEW.id;
            END;
        """;

        String triggerQuery = String.format(triggerTemplate, table, table);

        jdbcTemplate.execute(triggerQuery);
    }
}
