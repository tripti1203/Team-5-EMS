import { Component } from '@angular/core';
import { Bill } from 'src/app/bill';
import { BillService } from 'src/app/bill.service';

@Component({
  selector: 'app-bill-all',
  templateUrl: './bill-all.component.html',
  styleUrls: ['./bill-all.component.css']
})
export class BillAllComponent {

  bills!:Bill[];

  constructor(private billService:BillService){}
 
 ngOnInit(){
  this.billService.findAll().subscribe(data =>{
    this.bills = data;
  });
 }


 }

