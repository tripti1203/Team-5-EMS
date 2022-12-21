import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bill } from 'src/app/bill';
import { BillService } from 'src/app/bill.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-billgenerate',
  templateUrl: './billgenerate.component.html',
  styleUrls: ['./billgenerate.component.css']
})
export class BillgenerateComponent {
  newReading: any;
  id: any;
  constructor( private billService:BillService, private route: ActivatedRoute,
    private router: Router) { }
    bill123:Bill = new Bill();
    

  public bill={
    id:'',
    dateTime:'',
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
  onBillGene(){
   console.log(this.bill123.id);
   console.log(this.bill123.newReading);
   //add connection
   this.billService.generateBillByConnectionId(this.bill123.id,this.bill123.newReading).subscribe(
    (data)=>{
      console.log(data);
      Swal.fire('Bill Generated !!')
      
      //success
    },
    (error)=>{
      console.log(error);
      Swal.fire(' Id Doesnt Exit');
    }
    );
  }
}
