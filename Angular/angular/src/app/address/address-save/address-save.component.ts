import { Component,OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AddressService } from 'src/app/address.service';
import Swal from 'sweetalert2';
import { Router } from '@angular/router';
@Component({
  selector: 'app-address-save',
  templateUrl: './address-save.component.html',
  styleUrls: ['./address-save.component.css']
})
export class AddressSaveComponent implements OnInit {
  constructor(private addressService :AddressService,private router:Router){}
  public address={
    id: '',
    area: '',
    city: ''
  };
  ngOnInit(): void {}
 
  onAddressSave(){
    console.log(this.address);
    if(this.address.id == '' || this.address.id ==null){
      alert('Id is Required !!');
      return;
    }
  
  //this add address
  this.addressService.addAddress(this.address).subscribe(
    (data:any)=>{
      console.log(data);
      Swal.fire('Address Registered Successfully')
      this.goToConsumer();
      //success
    },
    (error:any)=>{
  
      console.log(error);
     Swal.fire('Something went Wrong')
    }
    );
  
  }
  goToConsumer(){
    this.router.navigate(['/consumer/save'])
  }
  }
  


