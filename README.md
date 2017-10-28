# References

* Based on https://blog.jdriven.com/2016/12/angular2-spring-boot-getting-started/
* Angular architecture - https://angular.io/guide/architecture#templates
* Routing - https://angular.io/guide/router

# Starting up for DEV

* In IntelliJ, start Angular2rescueApplication to initiate backend
* Angular dev server - C:\dev\angular2rescue\frontend\src\main\frontend>npm start
* http://localhost:4200/

# Next thing to do

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



## Debugging

If something stops working after a change, check the browser console log
