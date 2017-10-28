package com.crm114discriminator.angular2rescue.repositories;

import com.crm114discriminator.angular2rescue.entities.MotorsportEvent;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RunWith(SpringRunner.class)
@DataJpaTest
public class MotorsportEventRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MotorsportEventRepository motorsportEventRepository;

    @Test
    public void testRepoFindByName() {
        MotorsportEvent motorsportEvent = new MotorsportEvent();
        motorsportEvent.setCrewRequired(2);
        motorsportEvent.setUnitsRequired(1);
        motorsportEvent.setName("testevent");

        entityManager.persist(motorsportEvent);
        entityManager.flush();

        MotorsportEvent found = motorsportEventRepository.findByName("testevent");

        Assert.assertThat(found.getName(), CoreMatchers.is(motorsportEvent.getName()));


    }


}