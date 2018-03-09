import { Injectable } from '@angular/core';
import {Client} from "./model/client";
import {HttpClient} from "@angular/common/http";
import {Product} from "./model/products";
import {Date} from "./model/dates";


@Injectable()
export class Dataservice {

  constructor(public http: HttpClient) {
  }

  fetchClients(): Promise<Client[]> {

    return this.http
      .get('http://localhost:8080/farm-java/api/clients')
      .toPromise()
      .then(data => data as Client[])
  }

  fetchProducts(): Promise<Product[]> {

    return this.http
      .get('http://localhost:8080/farm-java/api/products')
      .toPromise()
      .then(data => data as Product[])
  }

  fetchDates(): Promise<Date[]> {

    return this.http
      .get('http://localhost:8080/farm-java/api/dates')
      .toPromise()
      .then(data => data as Date[])
  }

  /** Farmer */
  fetchClientWithProducts(client: Client): Promise<Client> {
    let url = 'http://localhost:8080/farm-java/api/clients/' + client.id;
    return this.http
      .get(url)
      .toPromise()
      .then(data => {
        console.log('Client with products: ', data);
        return data as Client
      })

  }


  createProduct(product: Product) {
    let url = 'http://localhost:8080/farm-java/api/products/';

    let dto = {

      name: product.name,
      id: product.id,
      client: null,
      price: product.price,
      farmer: {
        id: 1,
        name: "Roland"
      }
    };

    console.log('Sending product: ', product);
    // When posting, we send data to url
    return this.http.post(url, dto)
      .toPromise()
      .then(data => console.log('Success :)', data));
    //.catch(e => console.error('Fail :(', e));
  }

  deleteProduct(product: Product) {
    let url = 'http://localhost:8080/farm-java/api/products/' + product.id;

    console.log('Sending product: ', product);
    // When posting, we send data to url
    return this.http.delete(url)
      .toPromise()
      .then(data => console.log('Success :)', data));
    //.catch(e => console.error('Fail :(', e));
  }


  createDate(date: Date) {
    let url = 'http://localhost:8080/farm-java/api/dates/';

    let dto = {
      id: date.id,
      day: date.day,
      open: date.open,
      close: date.close,

    };
    console.log('Sending product: ', date);
    // When posting, we send data to url
    return this.http.post(url, dto)
      .toPromise()
      .then(data => console.log('Success :)', data));
    //.catch(e => console.error('Fail :(', e));

  }


  deleteDate(date: Date) {
    let url = 'http://localhost:8080/farm-java/api/dates/' + date.id;

    console.log('Sending product: ', date);
    // When posting, we send data to url
    return this.http.delete(url)
      .toPromise()
      .then(data => console.log('Success :)', data));
    //.catch(e => console.error('Fail :(', e));
  }
}
