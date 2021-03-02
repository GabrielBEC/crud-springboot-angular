import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from 'src/app/models/company.model';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {

  state: string = ''
  city: string = ''

  company: Company

  id = this.route.snapshot.paramMap.get('id')

  constructor(private companyService: CompanyService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.companyService.readById(this.id).subscribe(company => {
      const cityState = company.location.split(", ")
      this.city = cityState[0]
      this.state = cityState[1]
      this.company = company
    })
  }

  updateCompany(){    
    this.company.location = this.location(this.city, this.state)
    this.companyService.update(this.company).subscribe(() => {
      this.router.navigate([`/company/${this.id}`])
    })
  }

  location(city: string, state: string): string{
    return city +', '+state
  }
}
