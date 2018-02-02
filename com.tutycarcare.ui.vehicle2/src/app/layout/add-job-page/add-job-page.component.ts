import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Http } from "@angular/http";

@Component({
    selector: 'app-add-job-page',
    templateUrl: './add-job-page.component.html',
    styleUrls: ['./add-job-page.component.scss'],
    animations: [routerTransition()]
})
export class AddJobPageComponent implements OnInit {
    constructor(private http : Http) {
    }

    showPicker1 = false;
    showPicker2 = false;
    myDate1: Date = new Date();
    myDate2: Date = new Date();
    showDate = true;
    showTime = true;
    closeButton: any = { show: true, label: 'Close Me!', cssClass: 'btn btn-sm btn-primary' };

    onTogglePicker1() {
        if (this.showPicker1 === false) {
            this.showPicker1 = true;
        }
    }

    onTogglePicker2() {
        if (this.showPicker2 === false) {
            this.showPicker2 = true;
        }
    }
    onValueChange1(val: Date) {
        this.myDate1 = val;
        this.job.inTime=val;
        console.log(this.job.inTime)
    }

    onValueChange2(val: Date) {
        this.myDate2 = val;
        this.job.outTime = val;
        console.log(this.job.outTime);
    }

    
    ngOnInit() {
        this.getServices();
        this.jobLineItems.push(this.jobLineItem);
    }

    job: any = {
        vehicleId:'',
        estimatedCost: '',
        inTime: Date,
        outTime: Date,
        estimatedDelivery: Date
    };

    jobLineItem: any = {
        
            serviceId:'',
            name:'',
            description:'',
            estimatedCost:'',
            actualCost:''
    }

    jobLineItems: any = [];
    servicesList: any = [];
    vehicleModelsList: any = [];

    addNewJobLineItem(){
        let jobLineItem = {
            
                serviceId:'',
                name:'',
                description:'',
                estimatedCost:'',
                actualCost:''
        }
        this.jobLineItems.push(jobLineItem);
    }
    setJobLineItem(jobLineItem,$event){
        console.log($event);
        jobLineItem.estimatedCost=100;
    }
    getServices(){
        this.http.get('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/get_services').subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
            this.servicesList = JSON.parse(data['_body']);
            console.log(this.servicesList);
        });
    }
    
    createJob(){
        let data = this.job;
        data['jobLineItems'] = this.jobLineItems;

        this.http.put('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/create_job',data).subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
        });
    }
}
