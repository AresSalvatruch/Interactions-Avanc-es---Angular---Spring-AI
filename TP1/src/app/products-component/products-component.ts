import { NgForOf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-products-component',
  imports: [
    
  ],
  templateUrl: './products-component.html',
  styleUrl: './products-component.css'
})
export class ProductsComponent implements OnInit{

  products : any ;

constructor(private productService: ProductService) {

  
}

  ngOnInit(): void { 
    
    this.getAllProducts();
      
  }

getAllProducts() : void{

              this.productService.getAllProducts().subscribe({

                next : resp => {
                  this.products = resp;
                }, 
                error : err =>{
                  console.log(err);
                }
              });


}

  handleDelete(product: any):void {
    let v = confirm('êtes-vous sûr de vouloir supprimer?');
    if (v==true) {
this.productService.deleteProduct(product).subscribe({


          next : value =>{
            this.getAllProducts();
          },
          error : err =>{
            console.log(err);
          }

});
  }
  }
  }
