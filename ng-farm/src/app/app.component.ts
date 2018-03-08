import { Component } from '@angular/core';
import {PageService} from "./page.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // title = 'Welcome to ';

  constructor(public pageService:PageService){

  }

}
