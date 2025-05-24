import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EvaluationService {
  private apiUrl = 'http://localhost:8098/api/evaluations';
  constructor(private http: HttpClient) { }
  createEvaluation(payload: any) {
    return this.http.post(`${this.apiUrl}/create`, payload);
  }

  getAllEvaluations(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/all`);
  }

}
