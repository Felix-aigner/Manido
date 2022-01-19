import {LoginCredential} from "../../shared/models/loginCredential.model";
import {createAction, props} from "@ngrx/store";
import {UserDTO} from "../../shared/models/user.model";


export const postLogin = createAction('[Core] Post Login', props<{ loginCredentials: LoginCredential }>());
export const postLoginSuccess = createAction('[Core] Post Login Success', props<{ user: UserDTO }>());
export const postLoginFailure = createAction('[Core] Post Login Failure');



export const postRegistration = createAction('[Core] Post Registration', props<{ registration: UserDTO }>());
export const postRegistrationSuccess = createAction('[Core] Post Registration Success', props<{  user: UserDTO  }>());
export const postRegistrationFailure = createAction('[Core] Post Registration Failure');


export const logout = createAction('logout')
