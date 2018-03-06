import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { UserListViewComponent } from './user-list-view/user-list-view.component';
import {Dataservice} from "./data-service.service";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";


@NgModule({
  declarations: [
    AppComponent,
    UserListViewComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  providers: [Dataservice],
  bootstrap: [AppComponent]
})
export class AppModule { }
