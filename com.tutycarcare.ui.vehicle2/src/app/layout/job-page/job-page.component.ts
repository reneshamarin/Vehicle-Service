import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Http } from "@angular/http";

@Component({
    selector: 'app-vehicle-page',
    templateUrl: './job-page.component.html',
    styleUrls: ['./job-page.component.scss'],
    animations: [routerTransition()]
})
export class JobPageComponent implements OnInit {
    constructor(private http : Http) {
    }

    ngOnInit() {
        this.getJobs();
    }

    jobsList: any = [];
    getJobs(){
        this.http.get('http://localhost:9003/com.toothcloud.api.gateway/rest/tutycarcare/vehicle/get_jobs').subscribe(data => {
            // Read the result field from the JSON response.
            console.log(data['_body']);
            this.jobsList = JSON.parse(data['_body']);
            console.log(this.jobsList);
        });
    }
}
