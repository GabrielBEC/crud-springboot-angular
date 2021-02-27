import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CompaniesComponent } from './components/template/company/companies/companies.component';
import { CompanyComponent } from './components/template/company/company/company.component';
import { CreateCompanyComponent } from './components/template/company/create-company/create-company.component';
import { CreateFounderComponent } from './components/template/founder/create-founder/create-founder.component';

const routes: Routes = [
  {
    path: "",
    component: CompaniesComponent
  },
  {
    path: "company",
    component: CompanyComponent
  },
  {
    path: "company/create",
    component: CreateCompanyComponent
  },
  {
    path: "founder/create",
    component: CreateFounderComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
