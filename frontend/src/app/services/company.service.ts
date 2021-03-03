import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Company } from '../models/company.model';
import { environment } from '../../environments/environment'

@Injectable({
  providedIn: 'root'
})
export class CompanyService {

  base = environment.apiUrl
  baseUrl = `${this.base}/companies`

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

  update(company: Company): Observable<Company>{
    const url = `${this.baseUrl}/${company.id}`
    return this.http.put<Company>(url, company)
  }
}
