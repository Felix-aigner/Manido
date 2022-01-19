import {UserDTO} from "../../shared/models/user.model";
import {createReducer, on} from "@ngrx/store";
import {
  logout,
  postLoginSuccess,
  postRegistration,
  postRegistrationFailure,
  postRegistrationSuccess
} from "./core.actions";

export const coreFeatureKey = 'core'

export interface CoreState {
  currUser: UserDTO | undefined,
  token: String | undefined
}

export const initialState: CoreState = {
  currUser: undefined,
  token: undefined
}

export const reducer = createReducer(
  initialState,
  on(postLoginSuccess, (state, action) => ({
    ...state,
    token: action.user.token,
    currUser: action.user
  })),
  on(postRegistrationSuccess, (state, action) => ({
    ...state,
    token: action.user.token,
    currUser: action.user
  })),
  on(logout, (state, action) => ({
    ...state,
    token: undefined,
    currUser: undefined
  }))
)
