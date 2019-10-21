import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpResponseBase, HttpHeaders, HttpHeaderResponse } from '@angular/common/http';
import { User } from '../user';
import { FrontendserviceService } from '../frontendservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private token;
  constructor(private router:Router,private http:HttpClient,private FrontEndService:FrontendserviceService) { }

  ngOnInit() {
  }
   register()
  {
   this.router.navigateByUrl(`/register`)
  }

  user: User =new User();
  submitlogindetails(username,password): any
  {
    this.user.username=username;
    this.user.password=password;
    // var userpassobj={username:username,password:password};

   // let _url="http://localhost:8080/userLogin/authenticate";

   this.FrontEndService.login(this.user).subscribe((res)=>console.log(res));
    // this.http.post<User>(_url,this.user,{observe:'response'}).subscribe((response)=>{
    //   if(response.status==401) {
    //     console.log("****")
    //   }
    //     console.log("passed with "+response)
    
    // });

    
    // this.http.post<any>(_url).subscribe((data)=>{this.token=data;console.log(data)});
  }
}
