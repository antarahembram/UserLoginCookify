import { Component, OnInit ,Input} from '@angular/core';

@Component({
  selector: 'app-mastercard',
  templateUrl: './mastercard.component.html',
  styleUrls: ['./mastercard.component.css']
})
export class MastercardComponent implements OnInit {

  @Input() master_id;
  @Input() master_name;
  @Input() image_path;
  @Input() cu=[];

  constructor() { }

  ngOnInit() {
  }

}
