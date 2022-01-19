import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import {WerbeflaechenRoutingModule} from "./werbeflaechen-routing.module";
import {WerbeflaechenService} from "./services/werbeflaechen.service";
import {StoreModule} from "@ngrx/store";
import {werbeflaechenFeatureKey, werbeflaechenReducer} from "./store/werbeflaechen.reducer";
import {EffectsModule} from "@ngrx/effects";
import {WerbeflaechenEffects} from "./store/werbeflaechen.effects";
import { WerbeflaecheCardComponent } from './components/werbeflaeche-card/werbeflaeche-card.component';
import {MatCardModule} from "@angular/material/card";
import {MatButtonModule} from "@angular/material/button";
import {MatTooltipModule} from "@angular/material/tooltip";
import { CreateWerbeflaecheComponent } from './components/create-werbeflaeche/create-werbeflaeche.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {ReactiveFormsModule} from "@angular/forms";
import {MatSelectModule} from "@angular/material/select";
import {SharedModule} from "../shared/shared.module";
import {MatInputModule} from "@angular/material/input";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {NgbDatepickerModule} from "@ng-bootstrap/ng-bootstrap";
import { DatepickerComponent } from './components/datepicker/datepicker.component';
import { WerbeflaecheDetailsComponent } from './components/werbeflaeche-details/werbeflaeche-details.component';
import { BookingConfirmationComponent } from './components/booking-confirmation/booking-confirmation.component';



@NgModule({
  declarations: [
    DashboardComponent,
    WerbeflaecheCardComponent,
    CreateWerbeflaecheComponent,
    DatepickerComponent,
    WerbeflaecheDetailsComponent,
    BookingConfirmationComponent
  ],
  imports: [
    CommonModule,
    WerbeflaechenRoutingModule,
    StoreModule.forFeature(werbeflaechenFeatureKey, werbeflaechenReducer),
    EffectsModule.forFeature([WerbeflaechenEffects]),
    MatCardModule,
    MatButtonModule,
    MatTooltipModule,
    MatFormFieldModule,
    ReactiveFormsModule,
    MatSelectModule,
    SharedModule,
    MatInputModule,
    MatCheckboxModule,
    MatDatepickerModule,
    NgbDatepickerModule,
  ],
  providers: [
    WerbeflaechenService
  ],
  exports: [
    CreateWerbeflaecheComponent
  ]
})
export class WerbeflaechenModule { }
