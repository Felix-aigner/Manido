import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {selectToken} from "../../store/core.selectors";
import {map} from "rxjs/operators";
import {Store} from "@ngrx/store";
import {CoreState} from "../../store/core.reducer";
import {MatDialog} from "@angular/material/dialog";
import {LoginDialogComponent} from "../../../shared/components/login-dialog/login-dialog.component";
import {logout, postLogin, postRegistration} from "../../store/core.actions";
import {UserDTO} from "../../../shared/models/user.model";

@Component({
  selector: 'app-app-bar',
  templateUrl: './app-bar.component.html',
  styleUrls: ['./app-bar.component.scss']
})
export class AppBarComponent implements OnInit {
  @Input() routes: any[] = [];
  @Output() public sidenavToggle = new EventEmitter();

  loggedIn$ = this.store.select(selectToken).pipe(
    map((token) => {
      if(token) {
        console.log(true)
        return true
      }
      console.log(false)
      return false
    })
  )

  constructor(private store: Store<CoreState>, private dialog: MatDialog) {
  }

  ngOnInit(): void {
    //this.store.dispatch(testAction())
  }

  public onToggleSidenav = () => {
    this.sidenavToggle.emit();
  }


  openDialog(flag: string) {
    if (flag == 'Login') {
      const dialogRef = this.dialog.open(LoginDialogComponent, {
        width: '400px',
        minHeight: '350px'
      });
      dialogRef.afterClosed().subscribe(result => {
        if(result?.email) {
          this.store.dispatch(postRegistration({registration: result}))
        } else {
          this.store.dispatch(postLogin({loginCredentials: result}))
        }
      })
    }
  }

  logout() {
    this.store.dispatch(logout())
  }
}
