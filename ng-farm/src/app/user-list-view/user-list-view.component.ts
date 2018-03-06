import { Component, OnInit } from '@angular/core';
import {Client} from "../model/client";
import {Dataservice} from "../data-service.service";
import {Product} from "../model/products";

@Component({
  selector: 'app-user-list-view',
  templateUrl: './user-list-view.component.html',
  styleUrls: ['./user-list-view.component.css']
})
export class UserListViewComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
  products : Product[];

  constructor(public dataService: Dataservice) {
    dataService.fetchClients()
    .then(clients => this.clients = clients)
    .then(clients => console.log('Clients:', clients));

    dataService.fetchProducts()
      .then(products => this.products = products)
      .then(products => console.log('Products:', products));
  }

  ngOnInit() {
  }


  details(client: Client) {
    this.selectedClient = client;

    console.log('You selected', client);

      }

}
