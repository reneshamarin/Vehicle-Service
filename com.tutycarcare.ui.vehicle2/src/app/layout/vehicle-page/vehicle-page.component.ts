import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Http } from "@angular/http";

@Component({
    selector: 'app-vehicle-page',
    templateUrl: './vehicle-page.component.html',
    styleUrls: ['./vehicle-page.component.scss'],
    animations: [routerTransition()]
})
export class VehiclePageComponent implements OnInit {
    constructor(private http : Http) {
    }

    ngOnInit() {
        this.getVehicles();
    }

    vehicleList: any = [];
    getVehicles(){
        this.http.get('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/get_vehicles').subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
            this.vehicleList = JSON.parse(data['_body']);
            console.log(this.vehicleList);
        });
    }
}
