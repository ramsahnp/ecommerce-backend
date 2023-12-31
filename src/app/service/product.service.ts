import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private productUrl:string ="http://localhost:8080/api/products";

  constructor(private httpClient:HttpClient) { }

  getProductData():Observable<Product[]> {
   return this.httpClient.get<GetResponse>(this.productUrl).pipe(
      map(response => response._embedded.products)
    );
  }

 
}
interface GetResponse {
  _embedded:{
      products:Product[];
    }
}
