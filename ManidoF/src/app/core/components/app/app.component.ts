import { Component } from '@angular/core';
import {Store} from "@ngrx/store";
import {CoreState} from "../../store/core.reducer";
import {selectToken} from "../../store/core.selectors";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ManidoF';
  routes = [
    {title: 'Home', path: '/home'},
    {title: 'Werbeflächen', path: '/werbeflaechen'}
  ];

  constructor() {
  }
}
