import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

@NgModule({
  //the view classes that belong to this module. Angular has three kinds of view classes: components, directives, and pipes.
  declarations: [
    AppComponent
  ],

  //other modules whose exported classes are needed by component templates declared in this module.
  imports: [
    BrowserModule
  ],

  //creators of services that this module contributes to the global collection of services; they become accessible in all parts of the app.
  //Things in here can then be injected into classes that require them as dependencies (can also do in the components)
  //Gets injected through component constructor, eg constructor(private service: HeroService) { }
  providers: [],


  //the main application view, called the root component, that hosts all other app views. Only the root module should set this bootstrap property.
  bootstrap: [AppComponent]
})
//Export indicates it is public
export class AppModule { }
