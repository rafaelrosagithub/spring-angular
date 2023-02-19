import { Component, OnInit } from '@angular/core';
import { Client } from '../../clients/client';
import { ClientsService } from '../../clients.service'


@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent implements OnInit {

  clients: Client[];

  constructor(
    private clientService: ClientsService
  ) { }

  ngOnInit(): void {
    this.clientService.getClients().subscribe(res => {
      this.clients = res;
    }, error => {
      console.log("Error: ", error);
    })
  }

  onSubmit() {
    console.log("onSubmit()")
  }

}
