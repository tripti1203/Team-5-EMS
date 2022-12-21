import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GetAllAddressComponent } from './get-all-address.component';

describe('GetAllAddressComponent', () => {
  let component: GetAllAddressComponent;
  let fixture: ComponentFixture<GetAllAddressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GetAllAddressComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GetAllAddressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
