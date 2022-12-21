import { Component,OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Connections } from 'src/app/connections';
import { ConnectionsService } from 'src/app/connections.service';
import { Connectiontype } from 'src/app/connectiontype';
import { Consumer } from 'src/app/consumer';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-connectionsave',
  templateUrl: './connectionsave.component.html',
  styleUrls: ['./connectionsave.component.css']
})

export class ConnectionsaveComponent implements OnInit {
  constructor(private connectionService: ConnectionsService,private router:Router){
  }
 
 //connections:Connections = new Connections();
 //abc:abc = new abc();
  public connections={
    oldReading:'',
    addedOn: '',
    consumer:{
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
  onConnectionSave(){
   console.log(this.connections);
   //add connection
   this.connectionService.addConnection(this.connections).subscribe(
    (data)=>{
      console.log(data);
      Swal.fire('Connection Registered Succesfully')
      this.goToHome()
      
      //success
    },
    (error)=>{
      console.log(error);
      Swal.fire('Doesnt Exit');
    }
    );
  }

  goToHome(){
    this.router.navigate(['/consumer/save'])
  }

}
class abc{
  oldReading!:string ;
  addedOn!:string;
  consumerId!:number;
  connectionId!:number;
  constructor(){}
}

