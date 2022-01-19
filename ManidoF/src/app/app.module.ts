import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './core/components/app/app.component';
import {CoreModule} from "./core/core.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

@NgModule({
  declarations: [],
  imports: [
    BrowserModule,
    CoreModule,
    BrowserAnimationsModule,
    NgbModule,
    StoreDevtoolsModule.instrument({ maxAge: 25})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
