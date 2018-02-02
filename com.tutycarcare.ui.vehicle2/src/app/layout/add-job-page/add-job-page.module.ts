import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';
import { AddJobPageRoutingModule } from './add-job-page-routing.module';
import { AddJobPageComponent } from './add-job-page.component';
import { PageHeaderModule } from './../../shared';
import { DatetimePopupModule } from 'ngx-bootstrap-datetime-popup';
@NgModule({
  imports: [
    CommonModule,
    AddJobPageRoutingModule,
    PageHeaderModule,
    DatetimePopupModule,
    FormsModule
  ],
  declarations: [AddJobPageComponent]
})
export class AddJobPageModule { }
