import {createFeatureSelector, createSelector} from "@ngrx/store";
import {coreFeatureKey, CoreState} from "../../core/store/core.reducer";
import {werbeflaechenFeatureKey, WerbeflaechenState} from "./werbeflaechen.reducer";


export const selectWerbeflaechenState = createFeatureSelector<WerbeflaechenState>(werbeflaechenFeatureKey)

export const selectAdvertisements = createSelector(
  selectWerbeflaechenState,
  (state: WerbeflaechenState) => state.advertisements
)
