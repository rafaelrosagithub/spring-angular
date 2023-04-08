import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ServiceProvidedListComponent } from './service-provided-list.component';

describe('ServiceProvidedListComponent', () => {
  let component: ServiceProvidedListComponent;
  let fixture: ComponentFixture<ServiceProvidedListComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceProvidedListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceProvidedListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
