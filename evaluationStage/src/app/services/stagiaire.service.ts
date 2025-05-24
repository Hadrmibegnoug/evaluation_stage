import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StagiaireService {

  private basUrl = 'http://localhost:8098/api/stagiaires';

  constructor(private http: HttpClient) { }
  getStagiaires() {
    return this.http.get<any[]>(this.basUrl);
  }
  getStagiaireById(id: number) {
    return this.http.get<any>(`${this.basUrl}/${id}`);
  }
  addStagiaire(stagiaire: any) {
    return this.http.post<any>(this.basUrl, stagiaire);
  }
  updateStagiaire(id: number, stagiaire: any) {
    return this.http.put<any>(`${this.basUrl}/${id}`, stagiaire);
  }
  deleteStagiaire(id: number) {
    return this.http.delete<any>(`${this.basUrl}/${id}`);
  }

}
