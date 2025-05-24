import { CommonModule } from '@angular/common';
import { EvaluationService } from '../../../../services/evaluation.service';
import { Component, OnInit } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-tb-evaluation-stagiaire',
  imports: [CommonModule, RouterLink, RouterLinkActive],
  templateUrl: './tb-evaluation-stagiaire.component.html',
  styleUrl: './tb-evaluation-stagiaire.component.css'
})
export class TbEvaluationStagiaireComponent implements OnInit {
  evaluations: any[] = [];

  constructor(private evaluationService: EvaluationService) {}

  ngOnInit(): void {
    this.evaluationService.getAllEvaluations().subscribe((data: any[]) => {
      // Ajoute showDetails à chaque élément
      this.evaluations = data.map(e => ({
        ...e,
        showDetails: false
      }));
    });
  }

  toggleDetails(index: number): void {
    this.evaluations[index].showDetails = !this.evaluations[index].showDetails;
  }
}
