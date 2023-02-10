import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";

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

  constructor(private clientService: ClientsService, private router: Router) {
    this.client = new Client();
  }

  ngOnInit(): void {}

  onSubmit() {
    this.clientService.save(this.client).subscribe(
      (response) => {
        this.success = true;
        this.errors = [];
        this.client = response;
        console.log("resonse: ", response);
      },
      (errorResponse) => {
        this.success = false;
        this.errors = errorResponse.error.errors;
      }
    );
  }

  backToListing() {
    this.router.navigate(['/clients-list'])
  }
}
