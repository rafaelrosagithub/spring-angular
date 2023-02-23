import { Component, OnInit } from '@angular/core';
import { ServiceProvidedSearch } from './serviceProvidedSearch';
import { ServiceProvidedService } from '../../service-provided.service';

@Component({
  selector: 'app-service-provided-list',
  templateUrl: './service-provided-list.component.html',
  styleUrls: ['./service-provided-list.component.css']
})
export class ServiceProvidedListComponent implements OnInit {

  name: string;
  month: number;
  months: number[];
  list: ServiceProvidedSearch[];

  constructor(
    private service: ServiceProvidedService
  ) {
    this.months = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  }

  ngOnInit(): void {
  }

  search() {
    this.service.search(this.name, this.month).subscribe(response => {
      this.list = response;
      console.log("list: ", this.list)
    }, errorResponse => {
      console.log("Error: ", errorResponse)
    });
  }

}
