import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { PageHeaderModule } from './../../shared';
import { AddJobPageComponent } from './add-job-page.component';

describe('AddJobPageComponent', () => {
  let component: AddJobPageComponent;
  let fixture: ComponentFixture<AddJobPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({    
    imports: [
      RouterTestingModule,
      PageHeaderModule,
    ],
      declarations: [ AddJobPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddJobPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
