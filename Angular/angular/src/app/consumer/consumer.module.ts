import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConsumerSaveComponent } from './consumer-save/consumer-save.component';
import { ConsumerUpdateComponent } from './consumer-update/consumer-update.component';
import { ConsumerAllComponent } from './consumer-all/consumer-all.component';



@NgModule({
  declarations: [
    ConsumerSaveComponent,
    ConsumerUpdateComponent,
    ConsumerAllComponent
  ],
  imports: [
    CommonModule
  ]
})
export class ConsumerModule { }
