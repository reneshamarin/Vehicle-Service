import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddJobPageComponent } from './add-job-page.component';

const routes: Routes = [
    { path: '', component: AddJobPageComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AddJobPageRoutingModule { }
