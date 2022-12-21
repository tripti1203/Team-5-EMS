import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConnectionsaveComponent } from './connectionsave.component';

describe('ConnectionsaveComponent', () => {
  let component: ConnectionsaveComponent;
  let fixture: ComponentFixture<ConnectionsaveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConnectionsaveComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ConnectionsaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
