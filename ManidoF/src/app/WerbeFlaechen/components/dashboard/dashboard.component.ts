import { Component, OnInit } from '@angular/core';
import {selectAdvertisements} from "../../store/werbeflaechen.selectors";
import {WerbeflaechenState} from "../../store/werbeflaechen.reducer";
import {Store} from "@ngrx/store";
import {getWerbeflaechen, postWerbeflaeche} from "../../store/werbeflaechen.actions";
import {selectCurrUser} from "../../../core/store/core.selectors";
import {MatDialog} from "@angular/material/dialog";
import {CreateWerbeflaecheComponent} from "../create-werbeflaeche/create-werbeflaeche.component";
import {UserDTO} from "../../../shared/models/user.model";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  loggedIn = false
  currUser$ = this.store.select(selectCurrUser).pipe(map((user) => {
    if(user) this.loggedIn = true
    return user
  }))

  advertisements$ = this.store.select(selectAdvertisements)

  constructor(private store: Store<WerbeflaechenState>, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.store.dispatch(getWerbeflaechen())
  }

  createAd(user: UserDTO) {
    const dialogref = this.dialog.open(CreateWerbeflaecheComponent, {
      data: user,
      width: '500px',
      minHeight: '350px'
    });
    dialogref.afterClosed().subscribe(advert => {
      if(user.token)
        this.store.dispatch(postWerbeflaeche({advertisement: advert, token: user.token}))
    })
  }
}
