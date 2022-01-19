import {Injectable} from "@angular/core";
import {Actions, createEffect, ofType} from "@ngrx/effects";
import {WerbeflaechenService} from "../services/werbeflaechen.service";
import {
  getWerbeflaechen,
  getWerbeflaechenFailure,
  getWerbeflaechenSuccess,
  postWerbeflaeche, postWerbeflaecheSuccess
} from "./werbeflaechen.actions";
import {catchError, concatMap, map, mergeMap} from "rxjs/operators";
import {of} from "rxjs";
import {postRegistrationSuccess} from "../../core/store/core.actions";


@Injectable()
export class WerbeflaechenEffects {

  constructor(private action$: Actions, private werbeflaechenService: WerbeflaechenService) {
  }

  getAdvertisements$ = createEffect(() =>
    this.action$.pipe(
      ofType(getWerbeflaechen),
      concatMap((action) =>
        this.werbeflaechenService.getAll().pipe(
          map((result) => getWerbeflaechenSuccess({advertisements: result})),
          catchError(() => of(getWerbeflaechenFailure()))
        )
      )
    )
  )

  postAdvertisement$ = createEffect(() =>
    this.action$.pipe(
      ofType(postWerbeflaeche),
      concatMap((action) =>
        this.werbeflaechenService.postWerbeflaeche(action.advertisement, action.token).pipe(
          map(() => postWerbeflaecheSuccess()),
          catchError(() => of(getWerbeflaechenFailure()))
        )
      )
    )
  )

  postAdvertisementSuccess$ = createEffect(() =>
    this.action$.pipe(
      ofType(postWerbeflaecheSuccess),
      mergeMap((actions) => [
        getWerbeflaechen()
        ]
      )
    )
  )

}
