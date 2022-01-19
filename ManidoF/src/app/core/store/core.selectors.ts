import {createFeatureSelector, createSelector} from "@ngrx/store";
import {coreFeatureKey, CoreState} from "./core.reducer";


export const selectCoreState = createFeatureSelector<CoreState>(coreFeatureKey)

export const selectCurrUser = createSelector(
  selectCoreState,
  (state: CoreState) => state.currUser
)
export const selectToken = createSelector(
  selectCoreState,
  (state: CoreState) => state.token
)
