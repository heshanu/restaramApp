import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';
import { AddCategoryComponent } from './add-category/add-category.component';


@NgModule({
  declarations: [
    CustomerDashBoardComponent,
    AddCategoryComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }
