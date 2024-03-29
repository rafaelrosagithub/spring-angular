import { Component, OnInit } from '@angular/core';
import { ContactService } from '../contact.service';

import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Contact } from './contact';
import { MatDialog } from '@angular/material/dialog';

import { ContactDetailComponent } from '../contact-detail/contact-detail.component';
import { PageEvent } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {

  form: FormGroup;
  contacts: Contact[] = [];
  columns = ['photo', 'id', 'name', 'email', 'favorite'];  
  totalElements = 0;
  page = 0;
  size = 10;
  pageSizeOptions: number[] = [10];

  constructor(
    private service: ContactService,
    private formBuilder: FormBuilder,
    private matDialog: MatDialog,
    private snackBar: MatSnackBar
  ) { }

  ngOnInit(): void {
    this.mountForm();
    this.listContacts(this.page, this.size);
  }

  mountForm() {
    this.form = this.formBuilder.group({
      name: ['', Validators.required],
      email: ['', [Validators.email, Validators.required]]
    })
  }

  listContacts(page: number = 0, size: number = 10) {
    this.service.list(page, size).subscribe(response => {
      console.log("contacts", this.contacts)
      console.log("response", response)
      this.contacts = response.content;
      this.totalElements = response.totalElements;
      this.page = response.number;
    })
  }

  favorite(contact: Contact) {
    this.service.favorite(contact).subscribe(response => {
      contact.favorite = !contact.favorite;
    })
  }

  submit() {
    console.log("submit()")
    const formValues = this.form.value;
    const contact: Contact= new Contact(formValues.name, formValues.email);
    this.service.save(contact).subscribe(resp => {
      this.listContacts();
      this.snackBar.open("Contact has been added.", "Success!", {
        duration: 5000
      });
      this.form.reset();
    })
  }

  uploadPhoto(event, contact) {
    const files = event.target.files;
    if (files) {
      const photo = files[0];
      const formData: FormData = new FormData();
      formData.append("photo", photo);
      this.service.upload(contact, formData).subscribe( resp => {
        this.listContacts()
      });
    }
  }

  viewContact(contact: Contact) {
    this.matDialog.open(ContactDetailComponent, {
      width: '400px',
      height: '450px',
      data: contact
    })
  }

  changePage(event: PageEvent) {
    this.page = event.pageIndex;
    this.listContacts(this.page, this.size);
  }

}
