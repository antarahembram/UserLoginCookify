import { Component, OnInit } from '@angular/core';
import {FrontendserviceService} from '../frontendservice.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private frontendserviceservice:FrontendserviceService,private http:HttpClient) { }

  ngOnInit() {
  }

  registerUser(name,email,userName,password,city,state,country,age,gender)
  {
      var userObj={name:name,emailId:email,username:userName,password:password,city:city,state:state,country:country,age:age,gender:gender};

      var url="http://localhost:8080/userLogin/register";
      this.http.post(url,userObj).subscribe();
  }
}
