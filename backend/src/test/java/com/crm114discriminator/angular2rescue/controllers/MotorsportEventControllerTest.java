package com.crm114discriminator.angular2rescue.controllers;

import com.crm114discriminator.angular2rescue.entities.MotorsportEvent;
import com.crm114discriminator.angular2rescue.repositories.MotorsportEventRepository;
import org.apache.catalina.filters.CorsFilter;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Steve on 22/09/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class MotorsportEventControllerTest {
    private MockMvc mockMvc;

    //TODO - This desc
    /*
    Last thing done 22-09-17
    Attempt mock of motorsportevent controller. However, the repository in the controller seems to be null. Initialise
    a mock version of it. Also, as part of the set up, exceute a few posts into the repository so i've got some test
    data to work with (guessing its an in memory DB

     */

    @Mock
    private MotorsportEventRepository motorsportEventRepository;

    //Inject mocks, creates class and injects the things annotated with @Mock, like the repository above
    @InjectMocks
    private MotorsportEventController motorsportEventController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(motorsportEventController)
                .addFilters(new CorsFilter())
                .build();


        MotorsportEvent motorsportEvent = new MotorsportEvent();
        motorsportEvent.setCrewRequired(2);
        motorsportEvent.setName("event1");

        Mockito.when(motorsportEventRepository.findByName(motorsportEvent.getName()))
                .thenReturn(motorsportEvent);

    }

    @Test
    public void getEventByIdNotFound() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/event/123"))
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertThat(result.getResponse().getContentAsString(), CoreMatchers.containsString("no match for"));
    }

    @Test
    public void getEventById() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/event/search?name=event1")).andExpect(status().isOk()).andReturn();

        Assert.assertThat(result.getResponse().getContentAsString(), CoreMatchers.containsString("the ID was"));
    }

}