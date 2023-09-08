import { Component } from '@angular/core';
import { AppService } from '../app.service';
//import {HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent 
{
   
   constructor (private appService:AppService,
    private router:Router) {}
   onsubmit(txt1:string,txt2:string,txt3:string,txt4:string)
   {

     this.appService.onsubmitService(txt1,txt2,txt3,parseInt(txt4)).subscribe((response)=>{
      
      console.log(response)
      alert("Successfully Registered as Admin")
       this.router.navigate(['login'])

     },

     (error)=>{
      console.log(error)
      alert("User already Exist")
     })
   }

}
