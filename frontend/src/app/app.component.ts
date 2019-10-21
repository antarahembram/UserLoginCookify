import { Component } from "@angular/core";
import {Router, NavigationStart} from '@angular/router';

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent {
  title = "music-frontend";

  public shownav;

  constructor(router:Router) {
router.events.forEach((event) => {
    if(event instanceof NavigationStart) {
        this.shownav = event.url !== "/login";
    }
  });
}
}
