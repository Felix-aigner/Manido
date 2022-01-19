import {Advertisement} from "../../shared/models/advertisement.model";
import {createReducer, on} from "@ngrx/store";
import {getWerbeflaechenSuccess} from "./werbeflaechen.actions";


export const werbeflaechenFeatureKey = 'werbeflaechen'

export interface WerbeflaechenState {
  advertisements: Advertisement[]
}

export const initialState: WerbeflaechenState = {
  advertisements: []
}

export const werbeflaechenReducer = createReducer(
  initialState,
  on(getWerbeflaechenSuccess, (state, action) => ({
    ...state,
    advertisements: action.advertisements
  }))
)
