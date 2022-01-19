import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppComponent} from "./components/app/app.component";
import {HttpClientModule} from "@angular/common/http";
import {CoreRoutingModule} from "./core-routing.module";
import {RouterModule} from "@angular/router";
import {MatSidenavModule} from "@angular/material/sidenav";
import {AppBarComponent} from "./components/app-bar/app-bar.component";
import {MatListModule} from "@angular/material/list";
import {MatIconModule} from "@angular/material/icon";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {StoreModule} from "@ngrx/store";
import {reducer} from "./store/core.reducer";
import {CoreEffects} from "./store/core.effects";
import {EffectsModule} from "@ngrx/effects";
import {MatDialogModule} from "@angular/material/dialog";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CoreService} from "./services/core.service";
import {MatSelectModule} from "@angular/material/select";
import {MatOptionModule} from "@angular/material/core";



@NgModule({
  declarations: [
    AppComponent,
    AppBarComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    CoreRoutingModule,
    RouterModule,
    StoreModule.forRoot({core: reducer}, {}),
    EffectsModule.forRoot([CoreEffects]),
    MatSidenavModule,
    MatListModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatDialogModule,
    ReactiveFormsModule,
    FormsModule,
    MatSelectModule,
    MatOptionModule
  ],
  providers: [CoreService]
})
export class CoreModule { }
