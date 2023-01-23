import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HelloComponent } from './hello/hello.component';
import { TestAngularComponent } from './test-angular/test-angular.component'
import { ClientsModule } from './clients/clients.module'

@NgModule({
  declarations: [
    AppComponent,
    HelloComponent,
    TestAngularComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClientsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
