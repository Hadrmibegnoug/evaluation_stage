export class PeriodeModel {
  priodeId: number;
  dateDebut: string;
  dateFin: string;

  constructor(priodeId: number, dateDebut: string, dateFin: string) {
    this.priodeId = priodeId;
    this.dateDebut = dateDebut;
    this.dateFin = dateFin;
  }
  static fromJson(json: any): PeriodeModel {
    return new PeriodeModel(json.priodeId, json.dateDebut, json.dateFin);
  }
  static fromJsonArray(jsonArray: any[]): PeriodeModel[] {
    return jsonArray.map((json) => PeriodeModel.fromJson(json));
  }
  static toJson(periode: PeriodeModel): any {
    return {
      priodeId: periode.priodeId,
      dateDebut: periode.dateDebut,
      dateFin: periode.dateFin,
    };
  }
  static toJsonArray(periodes: PeriodeModel[]): any[] {
    return periodes.map((periode) => PeriodeModel.toJson(periode));
  }
}
