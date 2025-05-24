import { Component } from '@angular/core';
import { StageModel } from '../../../../models/stageModel/stage-model';
import { StageService } from '../../../../services/stage.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-details-stage',
  imports: [],
  templateUrl: './details-stage.component.html',
  styleUrl: './details-stage.component.css'
})
export class DetailsStageComponent {
  id: number = 0;
  stage: StageModel = new StageModel();
  constructor(private stageService: StageService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.id = params['id'];
    });
    this.stageService.getStageById(this.id).subscribe(
      (response: StageModel) => {
        this.stage = response;
        console.log(this.stage);
      }
      ,
      (error) => {
        console.error('Error fetching stage:', error);
      }
    );
  }
}
