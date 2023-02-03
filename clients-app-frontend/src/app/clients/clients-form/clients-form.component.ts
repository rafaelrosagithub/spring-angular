import { Component, OnInit } from '@angular/core';

import { Client } from '../client';
import { ClientsService } from '../../clients.service';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css'],
})
export class ClientsFormComponent implements OnInit {
  client: Client;

  constructor(private clientService: ClientsService) {
    this.client = new Client();
  }

  ngOnInit(): void {}

  onSubmit() {
    console.log('onSubmit()');
    this.clientService.save(this.client).subscribe((res) => {
      console.log('subscribe()');
      console.log('res: ', res);
      console.log('end subscribe()');
    });
    console.log('end onSubmit()');
  }
}
