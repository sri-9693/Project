import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin/admin.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';

const routes: Routes = [{path:"",redirectTo:"login",pathMatch:"full"},
{path:"register",component:AdminComponent},
  {path:"login",component:AdminloginComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule
 {
     
 }
