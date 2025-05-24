export class StageModel {
  stage_id: number;
  description: string;
  entreprise: string;
  objective: string;

  constructor(
    stage_id: number = 0,
    description: string = '',
    entreprise: string = '',
    objective: string = '',
  ) {
    this.stage_id = stage_id;
    this.description = description;
    this.entreprise = entreprise;
    this.objective = objective;
  }
  static fromJson(json: any): StageModel {
    return new StageModel(
      json.stage_id,
      json.description,
      json.entreprise,
      json.objective
    );
  }
  static fromJsonArray(jsonArray: any[]): StageModel[] {
    return jsonArray.map((json) => StageModel.fromJson(json));
  }
  static toJson(stage: StageModel): any {
    return {
      stage_id: stage.stage_id,
      description: stage.description,
      entreprise: stage.entreprise,
      objective: stage.objective,
    };
  }
}
