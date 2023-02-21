import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service'
import { ServiceProvided } from '../serviceProvided';


@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[];
  service: ServiceProvided;

  constructor(
    private clientService: ClientsService
  ) {
    this.service = new ServiceProvided();
  }

  ngOnInit(): void {
    this.clientService.getClients().subscribe(res => {
      this.clients = res;
    }, error => {
      console.log("Error: ", error);
    })
  }

  onSubmit() {
    console.log("onSubmit()")
    console.log("service: ", this.service)
  }

}
