import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list-table.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  
  products:Product[]=[];

  constructor(private productService:ProductService){}
  
  ngOnInit(): void {
    this.productList()
  }

  productList(){
   this.productService.getProductData().subscribe(data=>this.products=data);
  }

}