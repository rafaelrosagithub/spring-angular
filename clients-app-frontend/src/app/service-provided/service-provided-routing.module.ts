import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ServiceProvidedFormComponent } from './service-provided-form/service-provided-form.component';
import { ServiceProvidedListComponent } from './service-provided-list/service-provided-list.component';


const routes: Routes = [
  { path: 'service-provided-form', component: ServiceProvidedFormComponent},
  { path: 'service-provided-listing', component: ServiceProvidedListComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceProvidedRoutingModule { }
