import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from 'src/app/bill';
import { BillService } from 'src/app/bill.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-billyearmonth',
  templateUrl: './billyearmonth.component.html',
  styleUrls: ['./billyearmonth.component.css']
})
export class BillyearmonthComponent {
  year: any;
  month: any;

  constructor( private billService:BillService, private route: ActivatedRoute,
    private router: Router) { }
    bill123:Bill = new Bill();
    test :test=new test();
    

  public bill={
    id:'',
    dateTime:'',
    month:'',
    year:'',
    oldReading:'',
    newReading:'',
    billedUnits:'',
    totalAmount:'',
    consumer:{
        id:''    
    },
    connections:{
        id:''
    },
    connectionType:{
        id:''
    }
  };
    
  public consumer={
    id:'',
    firstName:'',
    lastName:'',
    addedOn:''

  };
public connectionType ={
  id:'',
  type:'',
  fixedCharge:'',
  perUnitCharge:'',
}


  ngOnInit(): void {
   
  }
  onBillYear(){
  console.log(this.test)
   this.billService.generateBillByMonthAndYear(this.month,this.year).subscribe(
    (data)=>{
      console.log(data);
      Swal.fire('Bill With Month Year!!')
      
      //success
    },
    (error)=>{
      console.log(error);
      Swal.fire('  Doesnt Exit');
    }
    );
  }
}
class test{
  year!:number
  month!:number
}
