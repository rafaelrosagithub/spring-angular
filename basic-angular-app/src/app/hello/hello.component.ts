import { Component } from '@angular/core'

@Component({
  selector: 'hello',
  templateUrl: './hello.component.html',
  styleUrls: []
})
export class HelloComponent {

  name: string;
  clients: Client[];

  constructor() {
    this.name = "Rafael Test";
    let fulano = new Client('Fulano', 18);
    let ciclano = new Client('Ciclano', 30);
    let bertrano = new Client('Bertrano', 25);
    this.clients = [fulano, ciclano, bertrano];
  }
}

class Client {
  constructor(
    public name: string,
    public age: number
  ) {}
}

