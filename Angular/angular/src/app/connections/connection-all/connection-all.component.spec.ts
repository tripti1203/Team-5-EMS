import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionAllComponent } from './connection-all.component';

describe('ConnectionAllComponent', () => {
  let component: ConnectionAllComponent;
  let fixture: ComponentFixture<ConnectionAllComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnectionAllComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConnectionAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
