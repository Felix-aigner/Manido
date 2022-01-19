import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {LoginCredential} from "../../shared/models/loginCredential.model";
import {Observable} from "rxjs";
import {UserDTO} from "../../shared/models/user.model";

@Injectable()
export class CoreService {
  constructor(private http: HttpClient) {
  }


  postLogin(credentials: LoginCredential): Observable<UserDTO> {
    return this.http.post<UserDTO>('http://localhost:8080/api/login', credentials)
  }

  postRegistration(user: UserDTO): Observable<UserDTO> {
    return this.http.post<UserDTO>('http://localhost:8080/api/signup', user)
  }
}
