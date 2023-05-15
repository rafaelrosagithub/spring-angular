import { Component, OnInit } from '@angular/core';
import { Contact } from './contact';
import { ContactService } from '../contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  name: string = "Hello!";

  constructor(
    private service: ContactService
  ) { }

  ngOnInit(): void {
    const c: Contact = new Contact();
    c.name = "Test 2";
    c.email = "teste2@hotmail.com"
    c.favorite = true;

    this.service.save(c).subscribe(resp => {
      console.log(resp);
    })
  }

}
