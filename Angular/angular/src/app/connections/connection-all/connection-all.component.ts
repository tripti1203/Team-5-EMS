import { Component } from '@angular/core';
import { Connections } from 'src/app/connections';
import { ConnectionsService } from 'src/app/connections.service';

@Component({
  selector: 'app-connection-all',
  templateUrl: './connection-all.component.html',
  styleUrls: ['./connection-all.component.css']
})
export class ConnectionAllComponent {
  connections!: Connections[];

  constructor(private connectionsService : ConnectionsService){ }

  ngOnInit(): void{

   this.getConnections();
  }

  private getConnections(){
    this.connectionsService.findAll().subscribe(data => {
      this.connections = data;
});
}
}
