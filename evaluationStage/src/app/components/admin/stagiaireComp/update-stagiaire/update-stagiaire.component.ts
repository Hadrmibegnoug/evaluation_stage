import { Component } from '@angular/core';
import { StagiaireModel } from '../../../../models/stagiaireModel/stagiaire-model';
import { StagiaireService } from '../../../../services/stagiaire.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TuteutModel } from '../../../../models/tuteut-model/tuteut-model';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-stagiaire',
  imports: [FormsModule, CommonModule],
  templateUrl: './update-stagiaire.component.html',
  styleUrl: './update-stagiaire.component.css'
})
export class UpdateStagiaireComponent {
  id: number = 0;
  stagiaire: StagiaireModel = new StagiaireModel();

  constructor(private stagiaireService: StagiaireService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.stagiaireService.getStagiaireById(this.id).subscribe(
      (response: StagiaireModel) => {
        this.stagiaire = response;
        console.log(this.stagiaire);
      },
      (error) => {
        console.error('Error fetching stagiaire:', error);
      }
    );
  }
  onSubmit() {
    // Handle form submission logic here
    console.log('Form submitted');
    console.log(this.stagiaire);
    this.updateStagiaire();
  }
  updateStagiaire() {
    this.stagiaireService.updateStagiaire(this.id, this.stagiaire).subscribe(
      (response: StagiaireModel) => {
        console.log('Stagiaire updated successfully:', response);
        // Optionally, navigate to another page or show a success message
        this.goToHome();
      },
      (error) => {
        console.error('Error updating stagiaire:', error);
      }
    );
  }

  goToHome() {
    // Navigate to the TuteurComponent route
    this.router.navigate(['/stagiaire']);
  }
}
