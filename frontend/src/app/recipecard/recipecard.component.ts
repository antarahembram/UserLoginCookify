import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-recipecard',
  templateUrl: './recipecard.component.html',
  styleUrls: ['./recipecard.component.css']
})
export class RecipecardComponent implements OnInit {

  @Input() recipe_name;
  @Input() cusine_name;
  @Input() image_path;
  @Input() serve;
  @Input() duration;
  @Input() published_on;
  @Input() master_name;
  @Input() rating_value;

  constructor() { }

  ngOnInit() {
  }

}
