import { ComponentFixture, TestBed, waitForAsync } from '@angular/core/testing';

import { ClientsFormComponent } from './clients-form.component';

describe('ClientsFormComponent', () => {
  let component: ClientsFormComponent;
  let fixture: ComponentFixture<ClientsFormComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientsFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientsFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
