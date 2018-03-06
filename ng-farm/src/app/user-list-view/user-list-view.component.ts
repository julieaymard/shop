import { Component, OnInit } from '@angular/core';
import {Client} from "../model/client";
import {Dataservice} from "../data-service.service";
import {Product} from "../model/products";
import {Date} from "../model/dates";

@Component({
  selector: 'app-user-list-view',
  templateUrl: './user-list-view.component.html',
  styleUrls: ['./user-list-view.component.css']
})
export class UserListViewComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
  products : Product[];
  dates : Date[];

  constructor(public dataService: Dataservice) {
    dataService.fetchClients()
    .then(clients => this.clients = clients)
    .then(clients => console.log('Clients:', clients));

    dataService.fetchProducts()
      .then(products => this.products = products)
      .then(products => console.log('Products:', products));

    dataService.fetchDates()
      .then(dates => this.dates = dates)
      .then(dates => console.log('Dates:', dates));
  }

  ngOnInit() {
  }


  details(client: Client) {
    this.selectedClient = client;

    console.log('You selected', client);

      }

}
