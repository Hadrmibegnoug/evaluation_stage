import { PeriodeModel } from "../periodeModel/periode-model";
import { TuteutModel } from "../tuteut-model/tuteut-model";

export class AppreciationModel {
  appreciationId: any;
  appreciationName: string;
  priode: PeriodeModel;
  tuteur: TuteutModel;

  constructor(
    appreciationId: any,
    appreciationName: string,
    priode: PeriodeModel,
    tuteur: TuteutModel
  ) {
    this.appreciationId = appreciationId;
    this.appreciationName = appreciationName;
    this.priode = priode;
    this.tuteur = tuteur;
  }
  static fromJson(json: any): AppreciationModel {
    return new AppreciationModel(
      json.appreciationId,
      json.appreciationName,
      PeriodeModel.fromJson(json.priode),
      TuteutModel.fromJson(json.tuteur)
    );
  }
  static fromJsonArray(jsonArray: any[]): AppreciationModel[] {
    return jsonArray.map((json) => AppreciationModel.fromJson(json));
  }
  static toJson(appreciation: AppreciationModel): any {
    return {
      appreciationId: appreciation.appreciationId,
      appreciationName: appreciation.appreciationName,
      priode: PeriodeModel.toJson(appreciation.priode),
      tuteur: TuteutModel.toJson(appreciation.tuteur),
    };
  }
  static toJsonArray(appreciations: AppreciationModel[]): any[] {
    return appreciations.map((appreciation) =>
      AppreciationModel.toJson(appreciation)
    );
  }
}
