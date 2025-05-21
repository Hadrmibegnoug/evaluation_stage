import { AppreciationModel } from "../appreciationModel/appreciation-model";

export class EvaluationModel {
  id: number;
  categorie: string;
  valeur: string;
  appreciation: AppreciationModel;
  constructor(
    id: number,
    categorie: string,
    valeur: string,
    appreciation: AppreciationModel
  ) {
    this.id = id;
    this.categorie = categorie;
    this.valeur = valeur;
    this.appreciation = appreciation;
  }
  static fromJson(json: any): EvaluationModel {
    return new EvaluationModel(
      json.id,
      json.categorie,
      json.valeur,
      AppreciationModel.fromJson(json.appreciation)
    );
  }
  static fromJsonArray(jsonArray: any[]): EvaluationModel[] {
    return jsonArray.map((json) => EvaluationModel.fromJson(json));
  }
  static toJson(evaluation: EvaluationModel): any {
    return {
      id: evaluation.id,
      categorie: evaluation.categorie,
      valeur: evaluation.valeur,
      appreciation: AppreciationModel.toJson(evaluation.appreciation),
    };
  }
  static toJsonArray(evaluations: EvaluationModel[]): any[] {
    return evaluations.map((evaluation) =>
      EvaluationModel.toJson(evaluation)
    );
  }
}
