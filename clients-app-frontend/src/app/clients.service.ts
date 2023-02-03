import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Client } from './clients/client';

@Injectable({
  providedIn: 'root',
})
export class ClientsService {
  constructor(private http: HttpClient) {}

  getClient(): Client {
    let client: Client = new Client();
    client.name = 'Teste Client';
    client.cpf = '77777777777';
    return client;
  }
}
