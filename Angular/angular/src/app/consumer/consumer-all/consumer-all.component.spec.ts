import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumerAllComponent } from './consumer-all.component';

describe('ConsumerAllComponent', () => {
  let component: ConsumerAllComponent;
  let fixture: ComponentFixture<ConsumerAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsumerAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsumerAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
