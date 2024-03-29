import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LayoutComponent } from '../layout/layout.component';
import { ServiceProvidedFormComponent } from './service-provided-form/service-provided-form.component';
import { ServiceProvidedListComponent } from './service-provided-list/service-provided-list.component';
import { AuthGuard } from '../auth.guard';


const routes: Routes = [
  {
    path: 'services-provided', component: LayoutComponent, canActivate: [AuthGuard], children: [
      { path: 'form', component: ServiceProvidedFormComponent },
      { path: 'list', component: ServiceProvidedListComponent },
      { path: '', redirectTo: '/services-provided/list', pathMatch: 'full'}
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ServiceProvidedRoutingModule { }
