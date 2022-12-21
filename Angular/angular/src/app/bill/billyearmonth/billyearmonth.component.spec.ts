import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BillyearmonthComponent } from './billyearmonth.component';

describe('BillyearmonthComponent', () => {
  let component: BillyearmonthComponent;
  let fixture: ComponentFixture<BillyearmonthComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BillyearmonthComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BillyearmonthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
