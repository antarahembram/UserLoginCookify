import { TestBed } from '@angular/core/testing';

import { FrontendserviceService } from './frontendservice.service';

describe('FrontendserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FrontendserviceService = TestBed.get(FrontendserviceService);
    expect(service).toBeTruthy();
  });
});
