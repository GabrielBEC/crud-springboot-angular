import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/template/header/header.component';
import { CompaniesComponent } from './components/template/company/companies/companies.component';
import { CompanyComponent } from './components/template/company/company/company.component';
import { CreateCompanyComponent } from './components/template/company/create-company/create-company.component';
import { CreateFounderComponent } from './components/template/founder/create-founder/create-founder.component';
import { HttpClientModule } from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { UpdateCompanyComponent } from './components/template/company/update-company/update-company.component'

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CompaniesComponent,
    CompanyComponent,
    CreateCompanyComponent,
    CreateFounderComponent,
    UpdateCompanyComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
