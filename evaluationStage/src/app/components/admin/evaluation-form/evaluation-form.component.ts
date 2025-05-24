import { EvaluationService } from './../../../services/evaluation.service';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { MatRadioModule } from '@angular/material/radio';
import { FormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-evaluation-form',
  imports: [ReactiveFormsModule, MatRadioModule, FormsModule, MatInputModule, MatTableModule, MatButtonModule],
  templateUrl: './evaluation-form.component.html',
  styleUrls: ['./evaluation-form.component.css'],
})
export class EvaluationFormComponent {
  form: FormGroup;

  constructor(private fb: FormBuilder, private http: HttpClient, private evaluationService: EvaluationService) {
    this.form = this.fb.group({
      // Stagiaire
      nom: [''],
      prenom: [''],
      email: [''],
      institution: [''],

      // Tuteur
      nomTuteur: [''],
      prenomTuteur: [''],
      emailTuteur: [''],
      entreprise: [''],

      // Stage
      description: [''],
      objectif: [''],

      // Période
      dateDebut: [''],
      dateFin: [''],

      // Appréciation générale
      implication: [''],
      ouverture: [''],
      qualite: [''],
      observation: [''],

      // Notes
      connaissanceE: [''],
      qualiteTravail: [''],
      qualiteCommunication: [''],
      respectDelaisE: [''],
      connaissanceEA: [''],
      qualiteTravailEA: [''],
      respectDelaisEA: [''],
      qualiteCommunicationEA: [''],
      prelim: [''],

      noteCompInd: [''],
      noteCompEnt: [''],
      noteCompScTec: [''],
      noteCompSpM: [''],

      // Compétences spécifiques métier
      comEv1: [''],
      EvVal1: [''],
      comEv2: [''],
      EvVal2: [''],
      comEv3: [''],
      EvVal3: [''],
      comEv4: [''],
      EvVal4: [''],
      comEv5: [''],
      EvVal5: ['']
    });
  }

  submit() {
    const data = this.form.value;

    const payload = {
      stagiaire: {
        nom: data.nom,
        prenom: data.prenom,
        email: data.email,
        institution: data.institution
      },
      tuteur: {
        nom: data.nomTuteur,
        prenom: data.prenomTuteur,
        email: data.emailTuteur,
        entreprise: data.entreprise
      },
      stage: {
        description: data.description,
        objective: data.objectif,
        entreprise: data.entreprise
      },
      periode: {
        dateDebut: data.dateDebut,
        dateFin: data.dateFin
      },
      appreciation: {
        appreciationName: "Travail remarquable" // valeur fixe ou à rendre dynamique
      },
      evaluations: [
        { categorie: 'Implication dans ses activités', valeur: data.implication },
        { categorie: 'OUVERTURES AUX AUTRES', valeur: data.ouverture },
        { categorie: 'QUALITE DE SES "PRODUCTIONS"', valeur: data.qualite },
        { categorie: 'OBSERVATIONS SUR L\'ENSEMBLE DU TRAVAIL ACCOMPLI', valeur: data.observation }
      ],
      competences: [
        {
          intitule: 'Compétences individuelles',
          note: data.noteCompInd,
          categories: [
            { intitule: 'Etre capacle d\'analyse et de synthèse', valeur: data.connaissanceE },
            { intitule: 'Etre capable de proposer des methodes et des axes de travail', valeur: data.qualiteTravail },
            { intitule: 'Etre capable de faire adherer les acteurs', valeur: data.respectDelais },
            { intitule: 'Etre capable de s\'autoevaluer', valeur: data.qualiteCommunication },
            { intitule: 'Etre capable d\'identifier des poblemes complexes', valeur: data.respectDelaisE }
          ]
        },
        {
          intitule: 'Compétences entreprise',
          note: data.noteCompEnt,
          categories: [
            { intitule: 'Etre capacle d\'analyse le fonctionnement de l\'entreprise d\'accueil', valeur: data.connaissanceEA },
            { intitule: 'Etre capable d\'analyser la démarche projet, et d\'organiser et de structurer un projet', valeur: data.qualiteTravailEA },
            { intitule: 'Etre capable d\'apprendre à déceler et à comprendre la politique environnementale de l\'entreprise', valeur: data.respectDelaisEA },
            { intitule: 'Etre capable de rechercher, de sélectionner l\'information nécessaire à ses activités', valeur: data.qualiteCommunicationEA }
          ]
        },
        {
          intitule: 'Compétences scientifiques et techniques',
          note: data.noteCompScTec,
          categories: [
            { intitule: 'Conception préliminaire', valeur: data.prelim }
          ]
        },
        {
          intitule: 'Compétences spécifiques métier',
          note: data.noteCompSpM, // ou rendre dynamique si besoin
          categories: [
            { intitule: data.comEv1, valeur: data.EvVal1 },
            { intitule: data.comEv2, valeur: data.EvVal2 },
            { intitule: data.comEv3, valeur: data.EvVal3 },
            { intitule: data.comEv4, valeur: data.EvVal4 },
            { intitule: data.comEv5, valeur: data.EvVal5 }
          ]
        }
      ]
    };

    console.log('Payload envoyé :', payload);
    this.evaluationService.createEvaluation(payload).subscribe(
      (response) => {
        console.log('Evaluation créée avec succès:', response);
        // Optionnel : rediriger ou afficher un message de succès
      },
      (error) => {
        console.error('Erreur lors de la création de l\'évaluation:', error);
        // Optionnel : afficher un message d'erreur
      }
    );
    // this.http.post('http://localhost:8098/api/evaluations/create', payload).subscribe({
    //   next: res => console.log('Succès:', res),
    //   error: err => console.error('Erreur:', err)
    // });
  }
}
