import { Component } from '@angular/core';
import { Address } from 'src/app/address';
import { AddressService } from 'src/app/address.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-get-all-address',
  templateUrl: './get-all-address.component.html',
  styleUrls: ['./get-all-address.component.css']
})
export class GetAllAddressComponent {
  address!: Address[];

  constructor(private addressService : AddressService){ }

  ngOnInit(): void{

   this.getAddress();
  }

  private getAddress(){
    this.addressService.getAddressList().subscribe(data => {
      this.address = data;
});
}

//delete
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
