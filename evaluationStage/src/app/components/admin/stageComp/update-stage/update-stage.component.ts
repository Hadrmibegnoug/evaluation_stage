import { Component } from '@angular/core';
import { StageModel } from '../../../../models/stageModel/stage-model';
import { StageService } from '../../../../services/stage.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-update-stage',
  imports: [FormsModule, CommonModule],
  templateUrl: './update-stage.component.html',
  styleUrl: './update-stage.component.css'
})
export class UpdateStageComponent {
  id: number = 0;
  stage: StageModel = new StageModel();

  constructor(private stageService: StageService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.stageService.getStageById(this.id).subscribe(
      (response: StageModel) => {
        this.stage = response;
        console.log(this.stage);
      }
      , (error) => {
        console.error('Error fetching stage:', error);
      }
    );
  }
  onSubmit() {
    // Handle form submission logic here
    console.log('Form submitted');
    console.log(this.stage);
    this.updateStage();
  }
  updateStage() {
    this.stageService.updateStage(this.id, this.stage).subscribe(
      (response: StageModel) => {
        console.log('Stage updated successfully:', response);
        // Optionally, navigate to another page or show a success message
        this.goToStage();
      }
      , (error) => {
        console.error('Error updating stage:', error);
      }
    );
  }

  goToStage() {
    // Navigate to the TuteurComponent route
    this.router.navigate(['/stage']);
  }

}
