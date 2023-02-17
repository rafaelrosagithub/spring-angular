import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceProvidedFormComponent } from './service-provided-form.component';

describe('ServiceProvidedFormComponent', () => {
  let component: ServiceProvidedFormComponent;
  let fixture: ComponentFixture<ServiceProvidedFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceProvidedFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceProvidedFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
