import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AddressSaveComponent } from './address/address-save/address-save.component';
import { BrowserAnimationsModule } from 
    '@angular/platform-browser/animations';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConsumerSaveComponent } from './consumer/consumer-save/consumer-save.component';
import { ConnectionsaveComponent } from './connections/connectionsave/connectionsave.component';
import { ConnectionAllComponent } from './connections/connection-all/connection-all.component';
import { BillAllComponent } from './bill/bill-all/bill-all.component';
import { GetAllAddressComponent } from './address/get-all-address/get-all-address.component';
import { ConsumerAllComponent } from './consumer/consumer-all/consumer-all.component';
import { BillgenerateComponent } from './bill/billgenerate/billgenerate.component';
import { BillbycityComponent } from './bill/billbycity/billbycity.component';
import { BillyearmonthComponent } from './bill/billyearmonth/billyearmonth.component';

@NgModule({
  declarations: [
    AppComponent,
    AddressSaveComponent,
    ConsumerSaveComponent,
    ConnectionsaveComponent,
    ConnectionAllComponent,
    BillAllComponent,
    GetAllAddressComponent,
    ConsumerAllComponent,
    BillAllComponent,
    BillgenerateComponent,
    BillbycityComponent,
    BillyearmonthComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
