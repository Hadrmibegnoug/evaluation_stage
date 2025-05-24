import { Routes } from '@angular/router';
import { StageComponent } from './components/admin/stageComp/stage/stage.component';
import { StagiareComponent } from './components/admin/stagiaireComp/stagiare/stagiare.component';
import { TuteurComponent } from './components/admin/tuteurComp/tuteur/tuteur.component';
import { CreateTuteurComponent } from './components/admin/tuteurComp/create-tuteur/create-tuteur.component';
import { UpdateTuteurComponent } from './components/admin/tuteurComp/update-tuteur/update-tuteur.component';
import { DetailsTuteurComponent } from './components/admin/tuteurComp/details-tuteur/details-tuteur.component';
import { EvaluationFormComponent } from './components/admin/evaluationComp/evaluation-form/evaluation-form.component';
import { TbEvaluationStagiaireComponent } from './components/admin/evaluationComp/tb-evaluation-stagiaire/tb-evaluation-stagiaire.component';
import { UpdateStagiaireComponent } from './components/admin/stagiaireComp/update-stagiaire/update-stagiaire.component';
import { DetailsStagiaireComponent } from './components/admin/stagiaireComp/details-stagiaire/details-stagiaire.component';
import { DetailsStageComponent } from './components/admin/stageComp/details-stage/details-stage.component';
import { UpdateStageComponent } from './components/admin/stageComp/update-stage/update-stage.component';

export const routes: Routes = [
  {path: 'tuteur', component: TuteurComponent},
  {path: 'home/evaluationForm', component: EvaluationFormComponent},
  {path: 'home', component: TbEvaluationStagiaireComponent},
  {path: 'stage', component: StageComponent},
  {path: 'stage/:id', component: UpdateStageComponent},
  {path: 'stagiaire', component: StagiareComponent},
  {path: 'tuteur/createTuteur', component: CreateTuteurComponent},
  {path: 'tuteur/:id', component: UpdateTuteurComponent},
  {path: 'stagiaire/:id', component: UpdateStagiaireComponent},
  {path: 'tuteur/detailsTuteur/:id', component: DetailsTuteurComponent},
  {path: 'stagiaire/detailsStagiaire/:id', component: DetailsStagiaireComponent},
  {path: 'stage/detailsStage/:id', component: DetailsStageComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
];
