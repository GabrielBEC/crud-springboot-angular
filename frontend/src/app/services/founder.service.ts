import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Founder } from '../models/founder.model';

@Injectable({
  providedIn: 'root'
})
export class FounderService {

  baseUrl = "http://localhost:8080/founders"

  constructor(private http: HttpClient) { }

  create(founder: Founder, id: string): Observable<Founder>{
    const url = `${this.baseUrl}/${id}`
    return this.http.put<Founder>(url, founder)
  }

}
