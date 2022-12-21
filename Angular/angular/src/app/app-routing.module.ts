import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddressSaveComponent } from './address/address-save/address-save.component';
import { AddressUpdateComponent } from './address/address-update/address-update.component';
import { GetAllAddressComponent } from './address/get-all-address/get-all-address.component';
import { BillAllComponent } from './bill/bill-all/bill-all.component';
import { BillbycityComponent } from './bill/billbycity/billbycity.component';
import { BillgenerateComponent } from './bill/billgenerate/billgenerate.component';
import { BillyearmonthComponent } from './bill/billyearmonth/billyearmonth.component';
import { ConnectionAllComponent } from './connections/connection-all/connection-all.component';
import { ConnectionsaveComponent } from './connections/connectionsave/connectionsave.component';
import { ConsumerAllComponent } from './consumer/consumer-all/consumer-all.component';
import { ConsumerSaveComponent } from './consumer/consumer-save/consumer-save.component';

const routes: Routes = [
  {path:'address/save',component:AddressSaveComponent},
  {path:'consumer/save' ,component:ConsumerSaveComponent},
  {path:'connections/save',component:ConnectionsaveComponent},
 {path:'bill/generate',component:BillgenerateComponent},
  {path:'connections/All',component:ConnectionAllComponent},
  {path:'consumer/All',component:ConsumerAllComponent},
  {path:'bill/All', component:BillAllComponent},
  {path:'address/addressAll',component:GetAllAddressComponent},
  {path:'bill/billyear',component:BillyearmonthComponent},
  {path:'bill/billcity',component:BillbycityComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
