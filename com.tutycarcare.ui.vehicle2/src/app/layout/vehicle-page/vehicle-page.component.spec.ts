import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { PageHeaderModule } from './../../shared';

import { VehiclePageComponent } from './vehicle-page.component';

describe('VehiclePageComponent', () => {
  let component: VehiclePageComponent;
  let fixture: ComponentFixture<VehiclePageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
    imports: [
      RouterTestingModule,
      PageHeaderModule,
    ],
      declarations: [ VehiclePageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VehiclePageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
