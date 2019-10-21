import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FrontendserviceService } from '../frontendservice.service';

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {


  public recipe=[];

  constructor(private http:HttpClient,private fservice:FrontendserviceService) { }

  ngOnInit() {
      
    this.fservice.getalltrendingrecipe().subscribe(data => {this.recipe=data; console.log(this.recipe,"data of trending recipe")});
  }

  tr(id)
  {
    console.log("clicked on trending recipe id:"+id);
  }
}
