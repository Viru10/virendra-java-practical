import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { NewAppoitmentComponent } from './new-appoitment/new-appoitment.component';
import { ViewAppoitmentComponent } from './view-appoitment/view-appoitment.component';

@NgModule({
  declarations: [
    AppComponent,
    NewAppoitmentComponent,
    ViewAppoitmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
