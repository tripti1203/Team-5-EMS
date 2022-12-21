import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsumerSaveComponent } from './consumer-save.component';

describe('ConsumerSaveComponent', () => {
  let component: ConsumerSaveComponent;
  let fixture: ComponentFixture<ConsumerSaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsumerSaveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConsumerSaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
