import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UserListViewComponent } from './user-list-view/user-list-view.component';
import {Dataservice} from "./data-service.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {FarmerListViewComponent} from "./farmer-list-view/farmer-list-view.component";
import {PageService} from "./page.service";


@NgModule({
  declarations: [
    AppComponent,
    UserListViewComponent,
    FarmerListViewComponent,
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule,
  ],
  providers: [Dataservice, PageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
