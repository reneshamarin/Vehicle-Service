import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VehiclePageRoutingModule } from './vehicle-page-routing.module';
import { VehiclePageComponent } from './vehicle-page.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
  imports: [
    CommonModule,
    VehiclePageRoutingModule,
    PageHeaderModule
  ],
  declarations: [VehiclePageComponent]
})
export class VehiclePageModule { }
