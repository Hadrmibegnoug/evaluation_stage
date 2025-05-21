import { AppreciationModel } from "../appreciationModel/appreciation-model";

export class CompetenceModel {
  id: number;
  intitule: string;
  note: string;
  appreciation: AppreciationModel;
  constructor(
    id: number,
    intitule: string,
    note: string,
    appreciation: AppreciationModel
  ) {
    this.id = id;
    this.intitule = intitule;
    this.note = note;
    this.appreciation = appreciation;
  }
  static fromJson(json: any): CompetenceModel {
    return new CompetenceModel(
      json.id,
      json.intitule,
      json.note,
      AppreciationModel.fromJson(json.appreciation)
    );
  }
  static fromJsonArray(jsonArray: any[]): CompetenceModel[] {
    return jsonArray.map((json) => CompetenceModel.fromJson(json));
  }
  static toJson(competence: CompetenceModel): any {
    return {
      id: competence.id,
      intitule: competence.intitule,
      note: competence.note,
      appreciation: AppreciationModel.toJson(competence.appreciation),
    };
  }
  static toJsonArray(competences: CompetenceModel[]): any[] {
    return competences.map((competence) =>
      CompetenceModel.toJson(competence)
    );
  }
}
