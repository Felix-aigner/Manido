import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {LoginDialogComponent} from "./components/login-dialog/login-dialog.component";
import {MatTabsModule} from "@angular/material/tabs";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatSelectModule} from "@angular/material/select";
import {MatOptionModule} from "@angular/material/core";



@NgModule({
  declarations: [
    LoginDialogComponent
  ],
  imports: [
    CommonModule,
    MatTabsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    FormsModule,
    MatSelectModule,
    MatOptionModule
  ],
  exports: [
    LoginDialogComponent
  ]
})
export class SharedModule { }
