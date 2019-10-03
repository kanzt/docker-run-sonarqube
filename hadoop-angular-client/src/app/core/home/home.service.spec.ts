import {inject, TestBed} from '@angular/core/testing';

import {HomeService} from './home.service';
import {HttpClientModule} from '@angular/common/http';

describe('HomeService', () => {
  beforeEach(() => TestBed.configureTestingModule({
    providers: [HomeService],
    imports: [HttpClientModule]
  }));

  // it('should be created', () => {
  //   const service: HomeService = TestBed.get(HomeService);
  //   expect(service).toBeTruthy();
  // });
  it('should be created', inject([HomeService], (service: HomeService) => {
    expect(service).toBeTruthy();
  }));
});
