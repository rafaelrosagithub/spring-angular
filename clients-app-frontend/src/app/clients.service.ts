import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from './clients/client';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ClientsService {

  apiURL: string = environment.apiURLBase + "/api/clients";

  constructor(private http: HttpClient) { }

  save(client: Client): Observable<Client> {
    console.log('save()');
    return this.http.post<Client>(this.apiURL, client);
  }

  update(client: Client): Observable<any> {
    console.log('update()');
    return this.http.put<Client>(`${this.apiURL}/${client.id}`, client);
  }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiURL);
  }

  getClientById(id: number): Observable<Client> {
    return this.http.get<any>(`${this.apiURL}/${id}`);
  }

  delete(client: Client): Observable<any> {
    return this.http.delete<any>(`${this.apiURL}/${client.id}`);
  }

}
