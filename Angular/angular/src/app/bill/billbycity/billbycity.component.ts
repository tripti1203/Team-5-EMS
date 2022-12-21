import { Component } from '@angular/core';
import { Bill } from 'src/app/bill';
import { BillService } from 'src/app/bill.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-billbycity',
  templateUrl: './billbycity.component.html',
  styleUrls: ['./billbycity.component.css']
})
export class BillbycityComponent {
  bills!:Bill[];
  
  public bill={
    id:'',
    dateTime:'',
    oldReading:'',
    newReading:'',
    billedUnits:'',
    totalAmount:'',
    consumer:{
        id:'',
        address:{
          id:'',
          area:'',
          city:''

        }    
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
public address={
  id: '',
  area: '',
  city: ''
};
  constructor(private billService:BillService){}
  onBillCity(){
    console.log(this.bill);
    //add consumer
    this.billService.generateBillByCityAndArea(this.bill.consumer.address.area,this.bill.consumer.address.city).subscribe(
     (data:any)=>{
       console.log(data);
       Swal.fire('Consumer Registered Succesfully')
       
       //alert('Consumer Registered Successfully')
       //success
     },
     (error:any)=>{
   
       console.log(error);
       Swal.fire('Address Id doesnt Exit')
     }
     );
   }
}
