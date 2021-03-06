import { Component, OnInit } from '@angular/core';
import {Client} from "../model/client";
import {Dataservice} from "../data-service.service";
import {Product} from "../model/products";
import {Date} from "../model/dates";
import {Farmer} from "../model/farmer";
import {PageService} from "../page.service";
import {_document} from "@angular/platform-browser/src/browser";

@Component({
  selector: 'app-farmer-list-view',
  templateUrl: './farmer-list-view.component.html',
  styleUrls: ['./farmer-list-view.component.css']
})

export class FarmerListViewComponent implements OnInit {
  clients: Client[];
  products : Product[]=[];
  dates : Date[];
  createdDate : Date = new Date();
  selectedClient: Client;
  //selectedProduct: Product;
  createdProduct : Product = new Product(); ////////////////////////// ICI

  showHide: boolean;

  constructor(public dataService: Dataservice, public pageService : PageService) {
    dataService.fetchClients()
      .then(clients => this.clients = clients)

      .then(clients => console.log('Clients:', clients));

    dataService.fetchProducts()
      .then(products => this.products = products)
      .then(products => console.log('Products:', products));

    dataService.fetchDates()
      .then(dates => this.dates = dates)
      .then(dates => console.log('Dates:', dates));

    /*dataService.fetchClientWithProducts(this.selectedClient)
      .then(client => this.selectedClient = client);*/
    this.showHide = true;
  }

  changeShowStatus(){
    this.showHide = !this.showHide;
  }


  ngOnInit() {
  }

  detailsC(client: Client) {
    this.selectedClient = client;
    this.createdProduct = new Product();
    this.createdProduct.client = client;
    //this.createdProduct.name = client.mail + " 's products";

    console.log('you selected', client);

    this.dataService
      .fetchClientWithProducts(client)
      /*      .fetchUserWithTopics(user)
           .fetchUserWithComments(user)*/
      .then(simpleClient => this.selectedClient = simpleClient)
      .then(console.log);
  }

  createProduct() {

    this.dataService.createProduct(this.createdProduct)
      .then(()=>this.products.push(
        Object.assign({}, this.createdProduct)))
      .then(()=> this.clearFields())
      .catch(e => alert(e.message));
  }


  deleteProduct(product: Product) {
    const index: number = this.products.indexOf(product);
    if (index !== -1) {
      this.products.splice(index, 1);
    }

     this.dataService.deleteProduct(product)
       .catch(e => alert(e.message));

  }

  createDate() {
    this.dataService.createDate(this.createdDate)
      .then(() => this.dates.push(
        Object.assign({}, this.createdDate)))
      .then(()=> this.clearFields())
      .catch(e => alert(e.message));
  }

  deleteDate(date: Date) {
    const index: number = this.dates.indexOf(date);
    if (index !== -1) {
      this.dates.splice(index, 1);
    }

    this.dataService.deleteDate(date)
      .catch(e => alert(e.message));
  }

  clearFields() {
    this.createdDate = new Date();
    this.createdProduct = new Product();
    //document.getElementById("textfield2").value = "";
  }

  // createDate() {
  //   /*this.dataService.createDate(this.createdDate)
  //     .then(()=>this.products.push(
  //       Object.assign({}, this.createdProduct)))
  //     .catch(e => alert(e.message));*/
  // }
  //
  // deleteDate(){
  //
  // }
}
