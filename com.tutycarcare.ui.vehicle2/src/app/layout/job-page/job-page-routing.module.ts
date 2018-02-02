import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { JobPageComponent } from './job-page.component';

const routes: Routes = [
    { path: '', component: JobPageComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class JobPageRoutingModule { }
