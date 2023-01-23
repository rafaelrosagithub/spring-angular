import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TestAngularComponent } from './test-angular.component';

describe('TestAngularComponent', () => {
  let component: TestAngularComponent;
  let fixture: ComponentFixture<TestAngularComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TestAngularComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TestAngularComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
