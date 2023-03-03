import { Component, OnInit } from '@angular/core';
import { ClientsService } from 'src/app/clients.service';
import { Client } from '../client';
import { Router } from "@angular/router";

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent implements OnInit {

  clients: Client[] = [];
  selectedClient: Client;
  successMessage: string;
  errorMessage: string;

  constructor(private service: ClientsService, private router: Router) { }

  ngOnInit(): void {
    this.service.getClients().subscribe(response => this.clients = response);
  }

  newRegister() {
    this.router.navigate(['/clients/form']);
  }

  prepareDeletion(client: Client) {
    this.selectedClient = client;
  }
  
  deleteClient() {
    console.log("deleteClient()", this.selectedClient)
    this.service.delete(this.selectedClient).subscribe(response => {
      this.errorMessage = null;
      this.successMessage = "Client deleted successfully!";
      this.ngOnInit();
    }, responseError => {
      this.successMessage = null;
      this.errorMessage = "An error ocurred while deleting the client.";
    })
  }

}
