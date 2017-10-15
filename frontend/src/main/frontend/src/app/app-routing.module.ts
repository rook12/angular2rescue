import { RouterModule, Routes } from "@angular/router";
import {NgModule} from "@angular/core";
import {HellooneComponent} from "./helloone.component";
import {UnitrootComponent} from "./unit/unitroot/unitroot.component";

const appRoutes: Routes = [
  {  path: 'hello-one',  component: HellooneComponent, data: {authorname: 'steveoo'}},
  { path:'units', component:UnitrootComponent},
  { path: '',
    redirectTo: '/hello-one',
    pathMatch: 'full'
  }
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
