import { EvaluationComponent } from './components/admin/evaluation/evaluation.component';
import { Routes } from '@angular/router';
import { StageComponent } from './components/admin/stage/stage.component';
import { StagiareComponent } from './components/admin/stagiare/stagiare.component';
import { TuteurComponent } from './components/admin/tuteur/tuteur.component';
import { CreateTuteurComponent } from './components/admin/create-tuteur/create-tuteur.component';
import { UpdateTuteurComponent } from './components/admin/update-tuteur/update-tuteur.component';
import { DetailsTuteurComponent } from './components/admin/details-tuteur/details-tuteur.component';

export const routes: Routes = [
  {path: 'tuteur', component: TuteurComponent},
  {path: 'home', component: EvaluationComponent},
  {path: 'evaluation', component: EvaluationComponent},
  {path: 'evaluation/:id', component: EvaluationComponent},
  {path: 'stage', component: StageComponent},
  {path: 'stagiaire', component: StagiareComponent},
  {path: 'tuteur/createTuteur', component: CreateTuteurComponent},
  {path: 'tuteur/:id', component: UpdateTuteurComponent},
  {path: 'tuteur/detailsTuteur/:id', component: DetailsTuteurComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
];
