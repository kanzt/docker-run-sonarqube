import {Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {HomeService} from './home.service';
import {FormControl, FormGroup} from '@angular/forms';
import {fromEvent, Subscription} from 'rxjs';
import {debounceTime, distinctUntilChanged, map, switchMap, tap} from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  movies: any[];
  cols: any[];
  formGroup: FormGroup;
  subscription: Subscription;
  @ViewChild('searchInput', {static: true}) searchInput: ElementRef;

  constructor(private homeService: HomeService) {
  }

  ngOnInit() {
    this.initForm();
    this.initFormEvent();
    this.homeService.getMovies().subscribe((movies: any[]) => this.movies = movies);
    this.cols = [
      {field: 'movieId', header: 'Movie ID'},
      {field: 'movieName', header: 'Movie Name'},
      {field: 'release', header: 'Release'},
      {field: 'imdbLink', header: 'IMDB'}
    ];
  }

  private initForm() {
    this.formGroup = new FormGroup({
      search: new FormControl(null)
    });
  }

  onSearch() {
    console.log(this.formGroup.get('search').value);
    this.homeService.searchMovies('Toy').subscribe((movies: any[]) => this.movies = movies);
  }

  private initFormEvent() {
    this.subscription = fromEvent(this.searchInput.nativeElement, 'input')
      .pipe(map((evt: any) => evt.target.value),
        distinctUntilChanged(), debounceTime(500),
        switchMap(search =>  this.homeService.searchMovies(search)))
      .subscribe((movies: any[]) => this.movies = movies);
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }
}
