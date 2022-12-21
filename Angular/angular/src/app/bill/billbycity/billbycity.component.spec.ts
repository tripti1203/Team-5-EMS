import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillbycityComponent } from './billbycity.component';

describe('BillbycityComponent', () => {
  let component: BillbycityComponent;
  let fixture: ComponentFixture<BillbycityComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillbycityComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillbycityComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
