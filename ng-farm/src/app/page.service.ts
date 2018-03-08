import { Injectable } from '@angular/core';

@Injectable()
export class PageService {

  page='client';

  data:any

  constructor() { }

  toggle(){
    // ternary operator
    this.page =   this.page==='client' ? 'farmer' : 'client';
  }


  isClient(){
    return this.page === 'client';
  }

  isFarmer(){
    return this.page === 'farmer';
  }
}
