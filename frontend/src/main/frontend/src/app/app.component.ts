import { Component } from '@angular/core';

//@Component is the decorator
//A directive is a class with a @Directive decorator. A component is a directive-with-a-template; a @Component
//decorator is actually a @Directive decorator extended with template-oriented features.
@Component({
  //CSS selector that tells Angular to create and insert an instance of this component where it finds a <app-root/> tag (in index.html)
  selector: 'rescue-app-root',

  //module-relative address of this component's HTML template
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],

  //Things in here can then be injected into classes that require them as dependencies
  //Registering at a component level means you get a new instance of the service with each new instance of that component.
  providers: []
})
export class RescueRootAppComponent {
  title = 'Rescue unit management system';
}
