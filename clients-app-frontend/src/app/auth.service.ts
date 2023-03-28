import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './login/user';

import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  apiURL: string = environment.apiURLBase + "/api/users";

  constructor(private http: HttpClient) { }

  save(user: User) : Observable<any> {
    return this.http.post<any>(this.apiURL, user);
  }
}
