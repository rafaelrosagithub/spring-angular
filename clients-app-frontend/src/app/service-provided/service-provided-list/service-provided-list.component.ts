import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-provided-list',
  templateUrl: './service-provided-list.component.html',
  styleUrls: ['./service-provided-list.component.css']
})
export class ServiceProvidedListComponent implements OnInit {

  name: string;
  month: number;
  months: number[];

  constructor() {
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
   }

  ngOnInit(): void {
  }

  search() {
    console.log("search()")
    console.log("Name:", this.name + ", Month:", this.month)
  }

}
