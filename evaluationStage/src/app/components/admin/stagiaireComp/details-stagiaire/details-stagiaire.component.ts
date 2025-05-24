import { Component } from '@angular/core';
import { StagiaireModel } from '../../../../models/stagiaireModel/stagiaire-model';
import { StagiaireService } from '../../../../services/stagiaire.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-stagiaire',
  imports: [],
  templateUrl: './details-stagiaire.component.html',
  styleUrl: './details-stagiaire.component.css'
})
export class DetailsStagiaireComponent {

  id: number = 0;
  stagiaire: StagiaireModel = new StagiaireModel();
  constructor(private stagiaireService: StagiaireService, private route: ActivatedRoute) { }

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

}
