import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FrontendserviceService } from '../frontendservice.service';

@Component({
  selector: 'app-master',
  templateUrl: './master.component.html',
  styleUrls: ['./master.component.css']
})
export class MasterComponent implements OnInit {


  public masterdata=[];

  constructor(private http:HttpClient,private fservice:FrontendserviceService) { }

  ngOnInit() {
       this.fservice.getalltopmasters().subscribe(data => {this.masterdata=data; console.log(this.masterdata,"in master")});
  }

  masterid(id)
  {
    console.log("clicked on master with id:"+id);
  }

}
