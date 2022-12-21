import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BillsaveComponent } from './billsave/billsave.component';
import { BillAllComponent } from './bill-all/bill-all.component';
import { BillUpdateComponent } from './bill-update/bill-update.component';
import { BillgenerateComponent } from './billgenerate/billgenerate.component';
import { BillyearmonthComponent } from './billyearmonth/billyearmonth.component';
import { BillbycityComponent } from './billbycity/billbycity.component';



@NgModule({
  declarations: [
    BillsaveComponent,
    BillAllComponent,
    BillUpdateComponent,
    BillgenerateComponent,
    BillyearmonthComponent,
    BillbycityComponent
  ],
  imports: [
    CommonModule
  ]
})
export class BillModule { }
