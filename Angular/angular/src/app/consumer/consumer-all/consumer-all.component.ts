import { Component } from '@angular/core';
import { Address } from 'src/app/address';
import { AddressService } from 'src/app/address.service';
import { Consumer } from 'src/app/consumer';
import { ConsumerService } from 'src/app/consumer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-consumer-all',
  templateUrl: './consumer-all.component.html',
  styleUrls: ['./consumer-all.component.css']
})
export class ConsumerAllComponent {
  consumer!:Consumer[];
  address!:Address[];


  constructor(private consumerService : ConsumerService,private addressService:AddressService){ }

  ngOnInit(): void{

   this.getConsumer();
  }

  private getConsumer(){
    this.consumerService.findAll().subscribe(data => {
      this.consumer = data;
});
}
deleteAddress(id: any){

  Swal.fire({
    icon:'info',
    title:'Are You Sure You Want To Delete?',
    confirmButtonText:'Delete',
    showCancelButton:true,
  }).then((result)=>{
    if(result.isConfirmed){
      this.addressService.deleteAddress(id).subscribe(
        (data)=>{
          this.address=  this.address.filter((address)=> address.id !=id);
          Swal.fire('Success','Address Id Deleted,','success')
        },(error)=>{
          Swal.fire('Error',' Error in deleting Address Id ,','error')
        }
       );
    }
  })
}
  
  
  

}
