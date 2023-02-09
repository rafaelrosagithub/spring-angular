import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from './clients/client';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ClientsService {
  constructor(private http: HttpClient) {}

  save(client: Client): Observable<Client> {
    console.log('save()');
    return this.http.post<Client>('http://localhost:8080/api/clients', client);
  }

  // getClients(): Observable<Client[]> {

  //   return null;
  // }

  getClients(): Client[] {
      let client = new Client();
      client.id = 1;
      client.name = "Ciclano";
      client.dateRegister = "19/10/2009";
      client.cpf = "12345678987";
    return [client];
  }
}
