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
  success: boolean = false;
  errors: String[];

  constructor(private clientService: ClientsService) {
    this.client = new Client();
  }

  ngOnInit(): void {}

  onSubmit() {
    console.log('onSubmit()');
    this.clientService.save(this.client).subscribe((response) => {
      console.log('res: ', response);
      this.success = true;
    }, errorResponse => {
      this.success = false;
      this.errors = errorResponse.error.errors;
      console.log("Error: ", errorResponse.error.errors);
    });
    console.log('end onSubmit()');
  }
}
