import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionUpdateComponent } from './connection-update.component';

describe('ConnectionUpdateComponent', () => {
  let component: ConnectionUpdateComponent;
  let fixture: ComponentFixture<ConnectionUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnectionUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConnectionUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
