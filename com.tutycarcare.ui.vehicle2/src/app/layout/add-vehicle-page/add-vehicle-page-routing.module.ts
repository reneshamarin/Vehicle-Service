import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddVehiclePageComponent } from './add-vehicle-page.component';

const routes: Routes = [
    { path: '', component: AddVehiclePageComponent }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class AddVehiclePageRoutingModule { }
