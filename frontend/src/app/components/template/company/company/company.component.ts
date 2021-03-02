import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Company } from 'src/app/models/company.model';
import { CompanyService } from 'src/app/services/company.service';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {

  company: Company

  id = this.route.snapshot.paramMap.get('id')
  
  constructor(private companyService: CompanyService, private router: Router, private route: ActivatedRoute) { }
  
  ngOnInit(): void {
    this.companyService.readById(this.id).subscribe(company => {
      this.company = company
    })
  }

  deleteCompany(){
    const question = confirm("Deseja deletar o/a "+this.company.name)
    if(question == true){
      this.companyService.delete(this.id).subscribe(() => {
        const resp = alert(this.company.name+" deletado com sucesso!")
        this.router.navigate(["/"])
      })
    }
  }
}
