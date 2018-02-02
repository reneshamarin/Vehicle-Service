import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { PageHeaderModule } from './../../shared';
import { AddVehiclePageComponent } from './add-vehicle-page.component';

describe('AddVehiclePageComponent', () => {
  let component: AddVehiclePageComponent;
  let fixture: ComponentFixture<AddVehiclePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({    
    imports: [
      RouterTestingModule,
      PageHeaderModule,
    ],
      declarations: [ AddVehiclePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddVehiclePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
