import {Component, OnInit} from '@angular/core';
import {Client} from "../model/client";
import {Dataservice} from "../data-service.service";
import {Product} from "../model/products";
import {Date} from "../model/dates";
import {CheckProduct} from "../model/checkProduct";
import {PageService} from "../page.service";

@Component({
  selector: 'app-user-list-view',
  templateUrl: './user-list-view.component.html',
  styleUrls: ['./user-list-view.component.css']
})
export class UserListViewComponent implements OnInit {
  clients: Client[] = [];
  selectedClient: Client;

  products: Product[] = [];
  dates: Date[] = []; // !!!!!!!!!!!!!!!!!
  selectedDate: Date;
  options: CheckProduct[] = [];
  selectedProducts: Product;


  constructor(public dataService: Dataservice, public pageService: PageService) {
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


    //pageService.data = 'I am some stupid data'
    pageService.data = [];
    pageService.myProducts = [];
    pageService.myProductsPrice = [];
    pageService.myTotalPrice = 0;
  }


  ngOnInit() {
  }


  details(client: Client) {
    this.selectedClient = client;

    console.log('You selected', client);

  }

  details1(date: Date) {
    this.selectedDate = date;

    console.log('You selected', date);

  }

  selectedOptions(): Product[] {


    const selectedProducts = this.options
      .filter(opt => opt.checked)
      .map(opt => opt.product);

    console.log(selectedProducts);
   // var p: Product[]=[];


    for (let i = 0; i < selectedProducts.length; i++) {
      console.log('>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ' + selectedProducts[i].name.length);
      this.pageService.myProducts[i]  = selectedProducts[i].name;
      this.pageService.myProductsPrice[i] = selectedProducts[i].price;

    }
       this.pageService.data = [this.selectedClient, this.selectedDate];


      return selectedProducts;
    }



  displayOptions() {
    console.log(this.options)
  }

  sum(): number {
    let total = 0;


    for (let i = 0; i < this.options.length; i++) {

      let product = this.options[i];
      if (this.options[i].checked == true) {
        console.log("===>" + product);
        total += product.product.price;
      }
    }
    console.log("===>" + total);

    this.pageService.myTotalPrice = total;

    return total;

  }

  clickMethod(name: string) {
    if(confirm("Would you like to Confirm your command")) {

    }
  }

}
