import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillAllComponent } from './bill-all.component';

describe('BillAllComponent', () => {
  let component: BillAllComponent;
  let fixture: ComponentFixture<BillAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
