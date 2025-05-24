export class TuteutModel {
  id?: number;
  email: string;
  nom: string;
  prenom: string;
  entreprise: string;

  constructor(
    email: string = '',
    nom: string = '',
    prenom: string = '',
    entreprise: string = ''
  ) {
    this.email = email;
    this.nom = nom;
    this.prenom = prenom;
    this.entreprise = entreprise;
  }
}
