export class StagiaireModel {
  id: number;
  nom: string;
  prenom: string;
  email: string;
  institution: string;

  constructor(
    id: number,
    nom: string,
    prenom: string,
    email: string,
    institution: string
  ) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.institution = institution;
  }
  static fromJson(json: any): StagiaireModel {
    return new StagiaireModel(
      json.id,
      json.nom,
      json.prenom,
      json.email,
      json.institution
    );
  }
  static fromJsonArray(jsonArray: any[]): StagiaireModel[] {
    return jsonArray.map((json) => StagiaireModel.fromJson(json));
  }
  static toJson(stagiaire: StagiaireModel): any {
    return {
      id: stagiaire.id,
      nom: stagiaire.nom,
      prenom: stagiaire.prenom,
      email: stagiaire.email,
      institution: stagiaire.institution,
    };
  }
  static toJsonArray(stagiaires: StagiaireModel[]): any[] {
    return stagiaires.map((stagiaire) => StagiaireModel.toJson(stagiaire));
  }
}
