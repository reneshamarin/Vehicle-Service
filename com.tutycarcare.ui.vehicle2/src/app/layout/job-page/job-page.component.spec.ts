import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { PageHeaderModule } from './../../shared';

import { JobPageComponent } from './job-page.component';

describe('VJobPageComponent', () => {
  let component: JobPageComponent;
  let fixture: ComponentFixture<JobPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
    imports: [
      RouterTestingModule,
      PageHeaderModule,
    ],
      declarations: [ JobPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JobPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
