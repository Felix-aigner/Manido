import {createAction, props} from "@ngrx/store";
import {Advertisement} from "../../shared/models/advertisement.model";


export const getWerbeflaechen = createAction('[Werbeflaechen] get Werbeflaechen');
export const getWerbeflaechenSuccess = createAction('[Werbeflaechen] get Werbeflaechen Success', props<{ advertisements: Advertisement[] }>());
export const getWerbeflaechenFailure = createAction('[Werbeflaechen] get Werbeflaechen Failure');

export const postWerbeflaeche = createAction('[Werbeflaechen] post Werbeflaeche', props<{advertisement: Advertisement, token: String}>());
export const postWerbeflaecheSuccess = createAction('[Werbeflaechen] post Werbeflaeche Success');
export const postWerbeflaecheFailure = createAction('[Werbeflaechen] post Werbeflaeche Failure');
