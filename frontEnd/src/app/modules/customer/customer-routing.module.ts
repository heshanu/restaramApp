import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerDashBoardComponent } from './customer-dash-board/customer-dash-board.component';

const routes: Routes = [
  {path: 'dashboard',component: CustomerDashBoardComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomerRoutingModule { }
