import { Component } from '@angular/core';
import { TuteutModel } from '../../../models/tuteut-model/tuteut-model';
import { TuteurService } from '../../../services/tuteur.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-tuteur',
  imports: [],
  templateUrl: './details-tuteur.component.html',
  styleUrl: './details-tuteur.component.css'
})
export class DetailsTuteurComponent {
  id: number = 0;
  tuteur: TuteutModel = new TuteutModel();
  constructor(private tuteurService: TuteurService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.tuteurService.getTuteurById(this.id).subscribe(
      (response: TuteutModel) => {
        this.tuteur = response;
        console.log(this.tuteur);
      },
      (error) => {
        console.error('Error fetching tuteur:', error);
      }
    );
  }

}
