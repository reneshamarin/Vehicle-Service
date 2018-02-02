import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from './layout.component';

const routes: Routes = [
    {
        path: '', component: LayoutComponent,
        children: [
            { path: 'dashboard', loadChildren: './dashboard/dashboard.module#DashboardModule' },
            { path: 'charts', loadChildren: './charts/charts.module#ChartsModule' },
            { path: 'tables', loadChildren: './tables/tables.module#TablesModule' },
            { path: 'forms', loadChildren: './form/form.module#FormModule' },
            { path: 'bs-element', loadChildren: './bs-element/bs-element.module#BsElementModule' },
            { path: 'grid', loadChildren: './grid/grid.module#GridModule' },
            { path: 'components', loadChildren: './bs-component/bs-component.module#BsComponentModule' },
            { path: 'blank-page', loadChildren: './blank-page/blank-page.module#BlankPageModule' },
            { path: 'vehicle-page', loadChildren: './vehicle-page/vehicle-page.module#VehiclePageModule' },
            { path: 'add-vehicle-page', loadChildren: './add-vehicle-page/add-vehicle-page.module#AddVehiclePageModule' },
            { path: 'add-job-page', loadChildren: './add-job-page/add-job-page.module#AddJobPageModule' },
            { path: 'job-page', loadChildren: './job-page/job-page.module#JobPageModule' },
            { path: 'report-page', loadChildren: './report-page/report-page.module#ReportPageModule' },
        ]
    }
];

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class LayoutRoutingModule { }
