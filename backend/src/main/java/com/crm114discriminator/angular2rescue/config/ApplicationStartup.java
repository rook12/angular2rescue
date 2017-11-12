package com.crm114discriminator.angular2rescue.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationStartup
        implements ApplicationListener<ApplicationReadyEvent> {

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        //Call the batch script in the cmd shell, trying to invoke it directly only executes 12 commands before hanging
        try {
            Process p = new ProcessBuilder("cmd", "/c", "", "start", "C:\\dev\\angular2rescue\\backend\\bin\\populateDb.bat").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}