import {Component, OnInit} from '@angular/core';
import {Client} from "../model/client";
import {Dataservice} from "../data-service.service";
import {Product} from "../model/products";
import {Date} from "../model/dates";
import {CheckProduct} from "../model/checkProduct";

@Component({
  selector: 'app-user-list-view',
  templateUrl: './user-list-view.component.html',
  styleUrls: ['./user-list-view.component.css']
})
export class UserListViewComponent implements OnInit {
  clients: Client[] = [];
  selectedClient: Client;
  products: Product[] = [];
  dates: Date[] =[]; // !!!!!!!!!!!!!!!!!
  selectedDate : Date;
  options: CheckProduct[] = [];
  selectedProducts : Product;

  constructor(public dataService: Dataservice) {
    dataService.fetchClients()
      .then(clients => this.clients = clients)
      .then(clients => console.log('Clients:', clients));

    dataService.fetchProducts()
      .then(products => {
        this.products = products
        this.options = this.products.map(p => new CheckProduct(p))
      })
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


  selectedOptions(): Product[] {


    const selectedProducts = this.options
      .filter(opt => opt.checked)
      .map(opt => opt.product);

    console.log(selectedProducts);
    return selectedProducts;

  }


  displayOptions() {
    console.log(this.options)
  }

  sum(): number {
    let total = 0;

    for (let i = 0; i < this.options.length; i++) {

      let product = this.options[i];
      if(this.options[i].checked==true){
        console.log("===>" +product);
        total += product.product.price ;
      }
    }
    console.log("===>" + total);

    return total;

  }

}
