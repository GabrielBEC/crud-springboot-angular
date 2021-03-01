import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Founder } from 'src/app/models/founder.model';
import { FounderService } from 'src/app/services/founder.service';

@Component({
  selector: 'app-create-founder',
  templateUrl: './create-founder.component.html',
  styleUrls: ['./create-founder.component.css']
})
export class CreateFounderComponent implements OnInit {


  founder: Founder = {
    fullName: '',
    title: ''
  }

  constructor(private founderService: FounderService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
  }

  createFounder(): void{
    const id = this.route.snapshot.paramMap.get('id')
    this.founderService.create(this.founder, id).subscribe(() => {
      this.router.navigate([`/company/${id}`])
    })
  }
}
