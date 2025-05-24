import { Component, OnInit } from '@angular/core';
import { StagiaireModel } from '../../../../models/stagiaireModel/stagiaire-model';
import { StagiaireService } from '../../../../services/stagiaire.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stagiare',
  imports: [CommonModule],
  templateUrl: './stagiare.component.html',
  styleUrl: './stagiare.component.css'
})
export class StagiareComponent implements OnInit {

  stagiaire: StagiaireModel[] = [];
  constructor(private stagireService: StagiaireService, private router: Router) {}
  ngOnInit(): void {
    this.getStagiaires();
  }

  private getStagiaires(): void {
    this.stagireService.getStagiaires().subscribe(
      (response: StagiaireModel[]) => {
        this.stagiaire = response;
        console.log(this.stagiaire);
      },
      (error) => {
        console.error('Error fetching stagiaires:', error);
      }
    );
  }

  deleteStagire(id: number): void {
    // Implement the logic to delete a tuteur
    console.log('Delete tuteur with ID:', id);
    this.stagireService.deleteStagiaire(id).subscribe(
      (response) => {
        console.log(`Stagiaire with ID ${id} deleted successfully:`, response);
        // Optionally, you can refresh the list of stagiaires after deletion
        this.getStagiaires();
      },
      (error) => {
        console.error('Error deleting stagiaire:', error);
      }
    );
  }

  editStagire(id: number): void {
    // Implement the logic to edit a stagiaire
    console.log('Edit stagiaire with ID:', id);
    this.router.navigate(['stagiaire', id]);
  }

  detailsStagire(id: number): void {
    // Implement the logic to view details of a stagiaire
    console.log('View details of stagiaire with ID:', id);
    this.router.navigate(['stagiaire/detailsStagiaire/', id]);
  }
}
