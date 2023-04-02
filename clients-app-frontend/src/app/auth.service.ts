import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './login/user';

import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURLBase + "/api/users";
  tokenURL: string = environment.apiURLBase + environment.getTokenURL;
  clientID: string = environment.clientId;
  clientSecret: string = environment.clientSecret;

  constructor(private http: HttpClient) { }

  save(user: User) : Observable<any> {
    return this.http.post<any>(this.apiURL, user);
  }

  tryLogin(username: string, password: string) : Observable<any> {
    const params = new HttpParams()
      .set('username', username)  
      .set('password', password)
      .set('grant_type', 'password')

    const headers = {
      'Authorization': 'Basic ' + btoa(`${this.clientID}:${this.clientSecret}`),
      'Content-Type': 'application/x-www-form-urlencoded' 
    }

    return this.http.post(this.tokenURL, params.toString, { headers });
  }
}
