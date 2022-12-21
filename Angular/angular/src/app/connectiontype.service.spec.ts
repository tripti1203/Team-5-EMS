import { TestBed } from '@angular/core/testing';

import { ConnectiontypeService } from './connectiontype.service';

describe('ConnectiontypeService', () => {
  let service: ConnectiontypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConnectiontypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
