import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { IgxIconModule, IgxListModule, IgxInputGroupModule, IgxSwitchModule, IgxButtonModule } from 'igniteui-angular';
import { VehiclesComponent } from './vehicles/vehicles.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    VehiclesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    IgxListModule,
    HttpClientModule,
    IgxIconModule,
    IgxInputGroupModule,
    IgxSwitchModule,
    IgxButtonModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
