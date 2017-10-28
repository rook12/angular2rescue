import { TestBed, inject } from '@angular/core/testing';

import { MotorsporteventService } from './motorsportevent.service';

describe('MotorsporteventService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MotorsporteventService]
    });
  });

  it('should be created', inject([MotorsporteventService], (service: MotorsporteventService) => {
    expect(service).toBeTruthy();
  }));
});
