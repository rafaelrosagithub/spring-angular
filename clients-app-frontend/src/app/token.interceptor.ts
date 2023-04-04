import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

  constructor() { }

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    console.log("intercept")
    const accessTokenString = localStorage.getItem('access_token');
    if (accessTokenString) {
      const accessTokenJSON = JSON.parse(accessTokenString);
      const jwt = accessTokenJSON.access_token;
      request = request.clone({
        setHeaders: {
          Authorization: 'Bearer ' + jwt
        }
      })
    }
    return next.handle(request);
  }
}