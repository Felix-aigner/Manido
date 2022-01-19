import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {Advertisement} from "../../shared/models/advertisement.model";

@Injectable({
  providedIn: 'root'
})
export class WerbeflaechenService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Advertisement[]> {
    return this.http.get<Advertisement[]>('http://localhost:8080/api/advertisement/all')
  }

  postWerbeflaeche(advertisement: Advertisement, token: String) {
    return this.http.post('http://localhost:8080/api/advertisement/create'
      , advertisement,
      {headers: new HttpHeaders()
          .set("Authorization", `Bearer ${token}`)
      })
  }
}
