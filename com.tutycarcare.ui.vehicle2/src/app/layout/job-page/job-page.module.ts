import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { JobPageRoutingModule } from './job-page-routing.module';
import { JobPageComponent } from './job-page.component';
import { PageHeaderModule } from './../../shared';

@NgModule({
  imports: [
    CommonModule,
    JobPageRoutingModule,
    PageHeaderModule
  ],
  declarations: [JobPageComponent]
})
export class JobPageModule { }
