import { RouterModule, Routes } from "@angular/router";
import {NgModule} from "@angular/core";
import {HellooneComponent} from "./helloone.component";
import {UnitrootComponent} from "./unit/unitroot/unitroot.component";
import {CrewComponent} from "./crew/crew.component";
import {EventsComponent} from "./components/events/events.component";
import {LandingComponent} from "./landing/landing.component";
import {EventdetailComponent} from "./components/eventdetail/eventdetail.component";

const appRoutes: Routes = [
  {  path: 'hello-one',  component: HellooneComponent, data: {authorname: 'steveoo'}},
  { path:'units', component:UnitrootComponent},
  { path:'crew', component:CrewComponent},
  { path:'events', component:EventsComponent},
  { path:'event-detail/:id', component:EventdetailComponent},
  { path: '', component:LandingComponent}
];

@NgModule( {
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: false // Debugging only
      }
    )
  ],
  exports : [RouterModule]
})

export class AppRoutingModule { }
