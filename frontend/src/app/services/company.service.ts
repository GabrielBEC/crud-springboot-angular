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

  create(company: Company): Observable<Company>{
    return this.http.post<Company>(this.baseUrl, company)
  }

  delete(id: string): Observable<Company>{
    const url = `${this.baseUrl}/${id}`
    return this.http.delete<Company>(url)
  }
}
