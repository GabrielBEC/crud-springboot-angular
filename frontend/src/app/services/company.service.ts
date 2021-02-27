import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Company } from '../models/company.model';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  baseUrl = "http://localhost:8080/companies"

  constructor(private http: HttpClient) { }

  read(): Observable<Company[]>{
    return this.http.get<Company[]>(this.baseUrl)
  }

  readById(id: string): Observable<Company>{
    const url = `${this.baseUrl}/${id}`
    return this.http.get<Company>(url)
  }
}
