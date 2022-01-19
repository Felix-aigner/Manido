import {Injectable} from "@angular/core";
import {CoreService} from "../services/core.service";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {
  postLogin,
  postLoginFailure,
  postLoginSuccess,
  postRegistration,
  postRegistrationFailure,
  postRegistrationSuccess
} from "./core.actions";
import {catchError, concatMap, map, mergeMap} from "rxjs/operators";
import {of} from "rxjs";


@Injectable()
export class CoreEffects {

  constructor(private action$: Actions, private coreService: CoreService) {
  }

  postLogin$ = createEffect(() =>
    this.action$.pipe(
      ofType(postLogin),
      concatMap((action) =>
        this.coreService.postLogin(action.loginCredentials).pipe(
          map((result) => postLoginSuccess({user: result})),
          catchError(() => of(postLoginFailure()))
        )
    )
  ))

  postRegistration$ = createEffect(() =>
    this.action$.pipe(
      ofType(postRegistration),
      concatMap((action) =>
        this.coreService.postRegistration(action.registration).pipe(
          map((result) => postRegistrationSuccess({user: result})),
          catchError(() => of(postRegistrationFailure()))
        )
    )
  ))
}
