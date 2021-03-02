import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Company } from 'src/app/models/company.model';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-create-company',
  templateUrl: './create-company.component.html',
  styleUrls: ['./create-company.component.css']
})
export class CreateCompanyComponent implements OnInit {

  state: string = ''
  city: string = ''

  company: Company = {
    name: '',
    description: '',
    location: '',
    foundedDate: '',
  }

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit(): void {
  }

  createCompany(): void{
    this.company.location = this.location(this.city, this.state)
    this.companyService.create(this.company).subscribe(() => {
      this.router.navigate(['/'])
    })
  }

  location(city: string, state: string): string{
    return city +', '+state
  }

}
