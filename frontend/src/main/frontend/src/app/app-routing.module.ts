import { RouterModule, Routes } from "@angular/router";
import { RescueRootAppComponent} from "./app.component";
import {NgModule} from "@angular/core";
import {HellooneComponent} from "./helloone.component";

const appRoutes: Routes = [
  {  path: 'hello-one',  component: HellooneComponent, data: {authorname: 'steveoo'}}
  /*,
  {
    path: '',
    component: RescueRootAppComponent
  },
  {
    path: '**', component: RescueRootAppComponent
  }*/
];

@NgModule( {
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {
        enableTracing: true // Debugging only
      }
    )
  ],
  exports : [RouterModule]
})

export class AppRoutingModule { }
