import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceProvided } from './service-provided/serviceProvided';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceProvidedService {

  apiURL: string = environment.apiURLBase + "/api/services-provided";

  constructor(private http: HttpClient) { }

  save(ServiceProvided: ServiceProvided): Observable<ServiceProvided> {
    return this.http.post<ServiceProvided>(this.apiURL, ServiceProvided);
  }
}
