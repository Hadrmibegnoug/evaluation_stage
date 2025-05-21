import { CompetenceModel } from '../competenceModel/competence-model';
export class CategorieModel {
  id: number;
  intitule: string;
  valeur: string;
  competence: CompetenceModel;

  constructor(
    id: number,
    intitule: string,
    valeur: string,
    competence: CompetenceModel
  ) {
    this.id = id;
    this.intitule = intitule;
    this.valeur = valeur;
    this.competence = competence;
  }
  static fromJson(json: any): CategorieModel {
    return new CategorieModel(
      json.id,
      json.intitule,
      json.valeur,
      CompetenceModel.fromJson(json.competence)
    );
  }
  static fromJsonArray(jsonArray: any[]): CategorieModel[] {
    return jsonArray.map((json) => CategorieModel.fromJson(json));
  }
  static toJson(categorie: CategorieModel): any {
    return {
      id: categorie.id,
      intitule: categorie.intitule,
      valeur: categorie.valeur,
      competence: CompetenceModel.toJson(categorie.competence),
    };
  }
  static toJsonArray(categorie: CategorieModel[]): any[] {
    return categorie.map((categorie) => CategorieModel.toJson(categorie));
  }
}
