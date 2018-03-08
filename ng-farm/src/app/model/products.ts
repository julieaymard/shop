import {Client} from "./client";
import {Farmer} from "./farmer";

export class Product {
  client?: Client;
  name : string;
  price: number;
  id: number;
  farmer?: Farmer;
}
