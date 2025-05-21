import { CommonModule } from '@angular/common';
import { TuteurService } from '../../../services/tuteur.service';
import { TuteutModel } from './../../../models/tuteut-model/tuteut-model';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-tuteur',
  imports: [CommonModule, RouterLink],
  templateUrl: './tuteur.component.html',
  styleUrl: './tuteur.component.css'
})
export class TuteurComponent {
  //TuteutModel: TuteutModel = new TuteutModel();
  tuteurs: TuteutModel[] = [];
  constructor(private tuteurService: TuteurService, private router: Router) {}
  ngOnInit(): void {
    this.getTuteurs();
  }

  private getTuteurs(): void {
    this.tuteurService.getTuteurs().subscribe(
      (response: TuteutModel[]) => {
        this.tuteurs = response;
        console.log(this.tuteurs);
      },
      (error) => {
        console.error('Error fetching tuteurs:', error);
      }
   );
  }

  editTuteur(id: number): void {
    // Implement the logic to edit a tuteur
    console.log('Edit tuteur with ID:', id);
    this.router.navigate(['tuteur', id]);
  }
  deleteTuteur(id: number): void {
    // Implement the logic to delete a tuteur
    console.log('Delete tuteur with ID:', id);
    this.tuteurService.deleteTuteur(id).subscribe(
      (response) => {
        console.log(`Tuteur with ID ${id} deleted successfully:`, response);
        // Optionally, you can refresh the list of tuteurs after deletion
        this.getTuteurs();
      },
      (error) => {
        console.error('Error deleting tuteur:', error);
      }
    );
  }

  detailsTuteur(id: number): void {
    // Implement the logic to view details of a tuteur
    console.log('View details of tuteur with ID:', id);
    this.router.navigate(['tuteur/detailsTuteur/', id]);
  }
}
