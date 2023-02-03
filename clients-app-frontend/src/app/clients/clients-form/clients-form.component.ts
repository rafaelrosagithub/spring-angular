import { Component, OnInit } from '@angular/core';

import { Client } from '../client';
import { ClientsService } from '../../clients.service';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;

  constructor(private clientService: ClientsService) {
    this.client = clientService.getClient();
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("click()");
    console.log("Client: ", this.client)
  }

}
