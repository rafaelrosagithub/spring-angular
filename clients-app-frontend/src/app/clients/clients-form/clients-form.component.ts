import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, Params } from "@angular/router";

import { Client } from '../client';
import { ClientsService } from '../../clients.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css'],
})
export class ClientsFormComponent implements OnInit {
  client: Client;
  success: boolean = false;
  errors: String[];
  id: number;

  constructor(
    private clientService: ClientsService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.client = new Client();
  }

  ngOnInit(): void {
    let params: Observable<Params> = this.activatedRoute.params;
    params.subscribe(urlParams => {
      this.id = urlParams['id'];
      if (this.id) {
        this.clientService.getClientById(this.id).subscribe(response => {
          this.client = response;
        }, errorResponse => {
          this.client = new Client();
        });
      }
    })

  }

  onSubmit() {
    if (this.id) {
      this.clientService.update(this.client).subscribe(response => {
        this.success = true;
        this.errors = null;
      }, responseError => {
        this.success = false;
        this.errors = ['Error when updating the client.'];
      });
    } else {
      this.clientService.save(this.client).subscribe(
        (response) => {
          this.success = true;
          this.errors = null;
          this.client = response;
          console.log("resonse: ", response);
        },
        (errorResponse) => {
          this.success = false;
          this.errors = errorResponse.error.errors;
        }
      );
    }
  }

  backToListing() {
    this.router.navigate(['/clients/list'])
  }
}
