import { Component } from '@angular/core';
import { TuteurService } from '../../../services/tuteur.service';
import { ActivatedRoute, Router } from '@angular/router';
import { TuteutModel } from '../../../models/tuteut-model/tuteut-model';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-tuteur',
  imports: [CommonModule, FormsModule],
  templateUrl: './update-tuteur.component.html',
  styleUrl: './update-tuteur.component.css'
})
export class UpdateTuteurComponent {

  id: number = 0;
  tuteur: TuteutModel = new TuteutModel();

  constructor(private tuteurSerice: TuteurService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.tuteurSerice.getTuteurById(this.id).subscribe(
      (response: TuteutModel) => {
        this.tuteur = response;
        console.log(this.tuteur);
      },
      (error) => {
        console.error('Error fetching tuteur:', error);
      }
    );
  }
  onSubmit() {
    // Handle form submission logic here
    console.log('Form submitted');
    console.log(this.tuteur);
    this.updateTuteur();
  }
  updateTuteur() {
    this.tuteurSerice.updateTuteur(this.id, this.tuteur).subscribe(
      (response) => {
        console.log(`Tuteur updated successfully:`, response);
        // Optionally, you can navigate to another page or show a success message
        this.goToTuteur();
      },
      (error) => {
        console.error('Error updating tuteur:', error);
        // Optionally, you can show an error message
      }
    );
  }

  goToTuteur() {
    // Navigate to the TuteurComponent route
    this.router.navigate(['/tuteur']);
  }
}
