# References

* Based on https://blog.jdriven.com/2016/12/angular2-spring-boot-getting-started/
* Angular architecture - https://angular.io/guide/architecture#templates
* Routing - https://angular.io/guide/router
* HATEOAS API linking - http://www.baeldung.com/spring-hateoas-tutorial
* Angular HTTP GET - https://www.concretepage.com/angular-2/angular-2-http-get-example

# Starting up for DEV

* In IntelliJ, start Angular2rescueApplication to initiate backend
* Angular dev server - C:\dev\angular2rescue\frontend\src\main\frontend>npm start
* http://localhost:4200/

# Next thing to do

* 21-12-17 Got debugger working (choose Browser Debug). Got editor working. Changed controller and event service to work around promises. Next expand editor to cover all fields. 
* 03-12-17 Work on getting NPM/JS debugger to work. Connection refused. Read into using promises instead of observable to simplify things
* 02-12-17 Got to submit stage, create a unit test for the Angular service that will do the update
* 29-11-17 Did some wiring around the event editor. Make the submit button work and talk to spring boot backend for update
* 13-11-17 Wire up event editor screen
* 12-11-17 Crew members attached to an event, pull them into the front end and display them for each event
* 01-11-17 - Look at link for implementing CRUD front/backend integration - http://javasampleapproach.com/spring-framework/spring-boot/use-angular-httpclient-post-put-delete-data-springboot-rest-apis-angular-4#1_Implement_new_CreateCustomerComponent
* Last thing done 30-10-17. Implemented HATEOAS links. Add link to front end representation not use API, so I can go to a page for each entry
* Routing (still to look at properly) - https://angular.io/guide/router
* Play with implementing some sort of message handling in back end.
* Securing pages / Login system
* Spring boot backend API for pulling data from a DB (or simulate it https://angular.io/tutorial/toh-pt6)
* Try implementing a sub module of rescue unit
* PrimeNG for UI components

## To create a new component

* Create a folder where you want the component
* Note this doesn't work in IntelliJ
* Navigate to component directory, then ng generate component componentname --skip-import

## Importing packages to npm

https://medium.com/codingthesmartway-com-blog/using-bootstrap-with-angular-c83c3cee3f4a

npm install bootstrap@3 jquery --save

Installs bootstrap v3 and jquery, and puts it into package.json

Alternately, use ng-bootstrap designed specifically for Angular

npm install --save @ng-bootstrap/ng-bootstrap
npm install bootstrap@4.0.0-alpha.6

## Security

https://github.com/mrin9/Angular-SpringBoot-REST-JWT

Adding dependency org.springframework.boot:spring-boot-starter-security automatically throws up 401

## Data

Many to many relationships - https://vladmihalcea.com/2017/05/10/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/

## Debugging

If something stops working after a change, check the browser console log
