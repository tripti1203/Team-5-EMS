import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GetAllAddressComponent } from './get-all-address/get-all-address.component';
import { AddressSaveComponent } from './address-save/address-save.component';
import { AddressUpdateComponent } from './address-update/address-update.component';



@NgModule({
  declarations: [
    GetAllAddressComponent,
    AddressSaveComponent,
    AddressUpdateComponent
  ],
  imports: [
    CommonModule
  ]
})
export class AddressModule { }
