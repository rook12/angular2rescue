import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RescueRootAppComponent} from './app.component';

import {HellooneComponent} from "./helloone.component";
import {AppRoutingModule} from "./app-routing.module";

import {Router} from "@angular/router";
import {UnitrootComponent} from "./unit/unitroot/unitroot.component";
import {NavbarComponent} from "./navbar/navbar.component";

import {NgbCollapseModule, NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {CrewComponent} from "./crew/crew.component";
import {EventsComponent} from "./components/events/events.component";
import {LandingComponent} from "./landing/landing.component";
import {HttpModule} from "@angular/http";
import {MotorsporteventService} from "./services/motorsportevent/motorsportevent.service";
import { EventdetailComponent } from './components/eventdetail/eventdetail.component';

@NgModule({
  //the view classes that belong to this module. Angular has three kinds of view classes: components, directives, and pipes.
  declarations: [
    RescueRootAppComponent,
    HellooneComponent,
    UnitrootComponent,
    NavbarComponent,
    CrewComponent,
    EventsComponent,
    LandingComponent,
    EventdetailComponent
  ],

  //other modules whose exported classes are needed by component templates declared in this module.
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule.forRoot(),
    NgbCollapseModule.forRoot(),
    HttpModule
  ],

  //creators of services that this module contributes to the global collection of services; they become accessible in all parts of the app.
  //Things in here can then be injected into classes that require them as dependencies (can also do in the components)
  //Gets injected through component constructor, eg constructor(private service: HeroService) { }
  providers: [MotorsporteventService],

  //the main application view, called the root component, that hosts all other app views. Only the root module should set this bootstrap property.
  bootstrap: [RescueRootAppComponent]
})

//Export indicates it is public
export class AppModule {

  //Debugging routing issues
  constructor(router : Router) {
    console.log('Routes - : ', JSON.stringify(router.config) )
  }

}
