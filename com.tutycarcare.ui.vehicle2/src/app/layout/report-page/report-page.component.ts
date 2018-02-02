import { Component, OnInit } from '@angular/core';
import { routerTransition } from '../../router.animations';
import { Http } from "@angular/http";

@Component({
    selector: 'app-vehicle-page',
    templateUrl: './report-page.component.html',
    styleUrls: ['./report-page.component.scss'],
    animations: [routerTransition()]
})
export class ReportPageComponent implements OnInit {
    constructor(private http : Http) {
    }

    ngOnInit() {
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
    }

    onValueChange2(val: Date) {
        this.myDate2 = val;
    }

}
