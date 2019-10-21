import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { FormsModule } from "@angular/forms";
import { HomecomponentComponent } from './homecomponent/homecomponent.component';
import { TrendingComponent } from './trending/trending.component';
import { Ng2CarouselamosModule } from 'ng2-carouselamos';
import {HttpClientModule} from '@angular/common/http';
import { MasterComponent } from './master/master.component';
import { AboutComponent } from './about/about.component';
import { FeaturesComponent } from './features/features.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { RecipecardComponent } from './recipecard/recipecard.component';
import { MastercardComponent } from './mastercard/mastercard.component';
import { FrontendserviceService } from './frontendservice.service';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
@NgModule({
  declarations: [AppComponent, HomecomponentComponent, TrendingComponent, MasterComponent, AboutComponent, FeaturesComponent, FooterComponent, LoginComponent, RecipecardComponent, MastercardComponent, NavbarComponent,RegisterComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    Ng2CarouselamosModule
  ],
  providers: [FrontendserviceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
