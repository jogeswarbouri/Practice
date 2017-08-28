import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import {LoginComponent} from './login/login.component'
import { AppComponent } from './app.component';
import {DataService} from './login/dataService'
import {HomeComponent} from './home/home.component'

@NgModule({
  
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpModule,
    RouterModule.forRoot([
    { path: '', redirectTo: 'login',pathMatch: 'full'},
    {path:'login',component:LoginComponent},
    {path:'login/:errormsg',component:LoginComponent},
    {path:'home/:role',component:HomeComponent}
   
   ]) 
  ],
  declarations: [AppComponent, LoginComponent,HomeComponent],

 providers: [DataService],
bootstrap: [AppComponent]
})
export class AppModule { }
