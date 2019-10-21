import { NgModule } from "@angular/core";
import { RouterModule } from "@angular/router";
import { Routes} from '@angular/router';
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { LoginComponent } from './login/login.component';
import {RegisterComponent} from './register/register.component';

const routes: Routes = [
  {path:'',redirectTo:'/homecomponent',pathMatch:'full'},
  {path:'homecomponent',component:HomecomponentComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:RegisterComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

export const routingComponent=[HomecomponentComponent,LoginComponent,RegisterComponent];
