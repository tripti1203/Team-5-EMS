import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumerUpdateComponent } from './consumer-update.component';

describe('ConsumerUpdateComponent', () => {
  let component: ConsumerUpdateComponent;
  let fixture: ComponentFixture<ConsumerUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsumerUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsumerUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
