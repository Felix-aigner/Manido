import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";

export const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'home'},
  {path: 'home', loadChildren: () => import('../home/home.module').then((m) => m.HomeModule)},
  {path: 'werbeflaechen', loadChildren: () => import('../WerbeFlaechen/werbeflaechen.module').then((m) => m.WerbeflaechenModule)}
]

@NgModule({
  declarations: [],
  imports: [

    RouterModule.forRoot(routes)]
})
export class CoreRoutingModule { }
