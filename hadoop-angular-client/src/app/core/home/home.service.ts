import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  constructor(private http: HttpClient) {
  }

  getMovies() {
    return this.http.get('/hadoop-hive-client/api/movies').pipe(tap(console.log));
  }

  searchMovies(text: string) {
    return this.http.post('/hadoop-hive-client/api/movies', {search: text}).pipe(tap(console.log));
  }
}
