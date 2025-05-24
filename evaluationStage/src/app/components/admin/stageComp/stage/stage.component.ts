import { Component } from '@angular/core';
import { StageModel } from '../../../../models/stageModel/stage-model';
import { StageService } from '../../../../services/stage.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-stage',
  imports: [CommonModule],
  templateUrl: './stage.component.html',
  styleUrl: './stage.component.css'
})
export class StageComponent {

  stage: StageModel[] = [];
  constructor(private stageService: StageService, private router: Router) {}
  ngOnInit(): void {
    this.getStages();
  }

  private getStages(): void {
    this.stageService.getStages().subscribe(
      (response: StageModel[]) => {
        this.stage = response;
        console.log(this.stage);
      }
      ,
      (error) => {
        console.error('Error fetching stages:', error);
      }
    );
  }

  deleteStage(id: number): void {
    // Implement the logic to delete a tuteur
    console.log('Delete tuteur with ID:', id);
    this.stageService.deleteStage(id).subscribe(
      (response) => {
        console.log(`Stage with ID ${id} deleted successfully:`, response);
        // Optionally, you can refresh the list of stages after deletion
        this.getStages();
      }
      ,
      (error) => {
        console.error('Error deleting stage:', error);
      }
    );
  }

  editStage(id: number): void {
    // Implement the logic to edit a stagiaire
    console.log('Edit stagiaire with ID:', id);
    this.router.navigate(['stage', id]);
  }

  detailsStage(id: number | undefined): void {
    if (id == null) {
      console.error('ID is undefined or null');
      return;
    }
    // Implement the logic to view details of a stagiaire
    console.log('View details of stagiaire with ID:', id);
    this.router.navigate(['stage/detailsStage/', id]);
  }


}
