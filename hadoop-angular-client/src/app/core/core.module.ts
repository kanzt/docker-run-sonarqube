import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import {TableModule} from 'primeng/table';
import {InputTextModule} from 'primeng/inputtext';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {SharedModule} from '../shared/shared/shared.module';
@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    TableModule,
    HttpClientModule,
    InputTextModule,
    ReactiveFormsModule,
    SharedModule
  ]
})
export class CoreModule { }
