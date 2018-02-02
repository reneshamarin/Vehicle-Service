import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddVehiclePageRoutingModule } from './add-vehicle-page-routing.module';
import { AddVehiclePageComponent } from './add-vehicle-page.component';
import { PageHeaderModule } from './../../shared';

import { FormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    AddVehiclePageRoutingModule,
    PageHeaderModule,
    FormsModule
  ],
  declarations: [AddVehiclePageComponent]
})
export class AddVehiclePageModule { 

}


