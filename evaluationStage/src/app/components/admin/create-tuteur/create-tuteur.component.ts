import { TuteurComponent } from './../tuteur/tuteur.component';
import { TuteurService } from './../../../services/tuteur.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Route, Router } from '@angular/router';
import { TuteutModel } from '../../../models/tuteut-model/tuteut-model';

@Component({
  selector: 'app-create-tuteur',
  imports: [FormsModule, CommonModule],
  templateUrl: './create-tuteur.component.html',
  styleUrl: './create-tuteur.component.css'
})
export class CreateTuteurComponent {
  tuteur: TuteutModel = new TuteutModel();
  errorMessage: String = 'Erreur de la soumission du formulaire';
  successMessage: String = 'Tuteur ajouté avec succès';
  loading: boolean = false;
  constructor(private tuteurService :TuteurService, private route: Router) {}
  onSubmit() {
    // Handle form submission logic here
    console.log('Form submitted');
    console.log(this.tuteur);
    this.insertTuteur();
    // You can send the tuteur object to your service or API here
  }
  onCancel() {
    // Handle cancel logic here
    console.log('Form cancelled');
  }

  insertTuteur() {
    this.loading = true;
    this.tuteurService.createTuteur(this.tuteur).subscribe(
      (response) => {
        console.log(`Tuteur created successfully:`, response);
        this.loading = false;
        this.goToTuteur();
        // Optionally, you can navigate to another page or show a success message
      },
      (error) => {
        console.error('Error creating tuteur:', error);
        this.loading = false;
        // Optionally, you can show an error message
      }
    );
  }

  goToTuteur() {
    // Navigate to the TuteurComponent route
    this.route.navigate(['/tuteur']);
  }

}
