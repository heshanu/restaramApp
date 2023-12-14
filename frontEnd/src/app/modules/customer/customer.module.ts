import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';


@NgModule({
  declarations: [
    CustomerDashBoardComponent
  ],
  imports: [
    CommonModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }
