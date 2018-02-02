import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FormsModule } from '@angular/forms';
import { ReportPageRoutingModule } from './report-page-routing.module';
import { ReportPageComponent } from './report-page.component';
import { PageHeaderModule } from './../../shared';
import { DatetimePopupModule } from 'ngx-bootstrap-datetime-popup';

@NgModule({
  imports: [
    CommonModule,
    ReportPageRoutingModule,
    PageHeaderModule,
    DatetimePopupModule,
    FormsModule
  ],
  declarations: [ReportPageComponent]
})
export class ReportPageModule { }
