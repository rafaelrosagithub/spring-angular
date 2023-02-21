import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service'
import { ServiceProvided } from '../serviceProvided';
import { ServiceProvidedService } from '../../service-provided.service';


@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[];
  service: ServiceProvided;

  constructor(
    private clientService: ClientsService,
    private serviceProvidedService: ServiceProvidedService
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
    this.serviceProvidedService.save(this.service).subscribe(response => {
      console.log("response: ", response)
    }, error => {

    });
  }

}
