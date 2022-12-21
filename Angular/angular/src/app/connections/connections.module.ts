import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConnectionsaveComponent } from './connectionsave/connectionsave.component';
import { ConnectionUpdateComponent } from './connection-update/connection-update.component';
import { ConnectionAllComponent } from './connection-all/connection-all.component';



@NgModule({
  declarations: [
    ConnectionsaveComponent,
    ConnectionUpdateComponent,
    ConnectionAllComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ConnectionsModule { }
