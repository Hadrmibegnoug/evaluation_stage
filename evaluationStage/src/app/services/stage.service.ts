import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StageService {

  private baseUrl: string = 'http://localhost:8098/api/stages';
  constructor(private httpClient: HttpClient) { }

  getStages() {
    return this.httpClient.get<any[]>(`${this.baseUrl}`);
  }
  getStageById(id: number) {
    return this.httpClient.get<any>(`${this.baseUrl}/${id}`);
  }
  addStage(stage: any) {
    return this.httpClient.post<any>(`${this.baseUrl}`, stage);
  }
  updateStage(id: number, stage: any) {
    return this.httpClient.put<any>(`${this.baseUrl}/${id}`, stage);
  }
  deleteStage(id: number) {
    return this.httpClient.delete<any>(`${this.baseUrl}/${id}`);
  }
}
