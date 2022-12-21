import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AddressService } from 'src/app/address.service';
import { ConsumerService } from 'src/app/consumer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-consumer-save',
  templateUrl: './consumer-save.component.html',
  styleUrls: ['./consumer-save.component.css']
})
export class ConsumerSaveComponent {

  constructor(private consumerService:ConsumerService,private addressService:AddressService,private router:Router){
  }
  public consumer={
    firstName:'',
    lastName: '',
    addedOn: '',
    address:{
      id:''
    }

  };
  public address={
    id: '',
    area: '',
    city: ''
  };



  ngOnInit(): void {
   
  }
  onConsumerSave(){
   console.log(this.consumer);
   //add consumer
   this.consumerService.addConsumer(this.consumer).subscribe(
    (data:any)=>{
      console.log(data);
      Swal.fire('Consumer Registered Succesfully')
      this.goToConnections()
      //alert('Consumer Registered Successfully')
      //success
    },
    (error:any)=>{
  
      console.log(error);
      Swal.fire('Address Id doesnt Exit')
    }
    );
  }
  goToConnections(){
    this.router.navigate(['/connections/save'])
  }
}
