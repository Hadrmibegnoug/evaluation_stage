import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { TuteutModel } from '../models/tuteut-model/tuteut-model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TuteurService {
  private baseUrl = 'http://localhost:8089/api/tuteur';
  constructor(private httpClienet: HttpClient) { }
  getTuteurs(): Observable<TuteutModel[]> {
    return this.httpClienet.get<TuteutModel[]>(`${this.baseUrl}`);
  }
  createTuteur(tuteur: TuteutModel): Observable<object> {
    return this.httpClienet.post(`${this.baseUrl}`, tuteur);
  }
  getTuteurById(id: number): Observable<TuteutModel> {
    return this.httpClienet.get<TuteutModel>(`${this.baseUrl}/${id}`);
  }
  updateTuteur(id: number, tuteur: TuteutModel): Observable<object> {
    return this.httpClienet.put(`${this.baseUrl}/${id}`, tuteur);
  }
  deleteTuteur(id: number): Observable<object> {
    return this.httpClienet.delete(`${this.baseUrl}/${id}`);
  }
}
