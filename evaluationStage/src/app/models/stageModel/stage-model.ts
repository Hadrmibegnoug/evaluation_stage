export class StageModel {
  stageId: number;
  description: string;
  objectives: string;
  entreprise: string;

  constructor(
    stageId: number,
    description: string,
    objectives: string,
    entreprise: string
  ) {
    this.stageId = stageId;
    this.description = description;
    this.objectives = objectives;
    this.entreprise = entreprise;
  }
  static fromJson(json: any): StageModel {
    return new StageModel(
      json.stageId,
      json.description,
      json.objectives,
      json.entreprise
    );
  }
  static fromJsonArray(jsonArray: any[]): StageModel[] {
    return jsonArray.map((json) => StageModel.fromJson(json));
  }
  static toJson(stage: StageModel): any {
    return {
      stageId: stage.stageId,
      description: stage.description,
      objectives: stage.objectives,
      entreprise: stage.entreprise,
    };
  }
}
