import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Http } from "@angular/http";
@Component({
    selector: 'app-add-vehicle-page',
    templateUrl: './add-vehicle-page.component.html',
    styleUrls: ['./add-vehicle-page.component.scss'],
    animations: [routerTransition()]
})

export class AddVehiclePageComponent implements OnInit {
    constructor(private http : Http) {
    }

    ngOnInit() {
        this.getVehicleBrands();

    }

   
    vehicle: any = {
            id:'',
            vehicleType : {
                brandId: '',
                modelId: ''
            },
            registrationNumber: '',
            insurance : {
                policyNum : '',
                companyName: '',
                expiryDate: ''
            }
    };
    customer: any = {
        firstname: '',
        lastname: '',
        email: '',
        phonenumber:''
    };
    
    
    vehicleBrandsList: any = [];
    vehicleModelsList: any = [];
    getVehicleBrands(){
        this.http.get('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/get_vehicle_brands').subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
            this.vehicleBrandsList = JSON.parse(data['_body']);
            console.log(this.vehicleBrandsList);
        });
    }
    
    brandId:number=1;
    getVehicleModels(){
        this.http.get('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/get_vehicle_models'+'?brandId='+ this.vehicle.vehicleType.brandId).subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
            this.vehicleModelsList = JSON.parse(data['_body']);
            console.log(this.vehicleModelsList);
        });
    }

    setBrandId($event){
        console.log($event.target);
        console.log(this.vehicle.vehicleType.brandId);
        this.vehicle.vehicleType.brandId = $event.target.value;
        this.getVehicleModels();
    }

    setModelId($event){
        console.log($event.target);
        console.log(this.vehicle.vehicleType.modelId);
        this.vehicle.vehicleType.modelId = $event.target.value;
    }

    createVehicle(){
        let data = this.vehicle;

        this.http.put('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/add_vehicle',data).subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
        });
    }
}
