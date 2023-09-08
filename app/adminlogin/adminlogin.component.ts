import { Component } from '@angular/core';
import { AppService } from '../app.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent 
{
  
  constructor(private appService:AppService,
    private router:Router) {}

  onLogin(txt1:string,txt2:string)
  
  {
     this.appService.onLoginService(txt1,txt2).subscribe((response)=>{

      if(response)
      {
        alert("Login Success")
      } 
      
      else{
        alert("Invalid Email or Password")
      }
     },
     (error)=>
     {
         console.log(error)
     })

  }
  goToReg()
  {
     this.router.navigate(['register']);
  }

}
