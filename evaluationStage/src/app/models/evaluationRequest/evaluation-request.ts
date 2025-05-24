export interface EvaluationRequest {
  stagiaire: {
    stagiaireId?: number;
    nom: string;
    prenom: string;
    email: string;
    institution: string;
  };
  tuteur: {
    tuteurId?: number;
    nom: string;
    prenom: string;
    email: string;
    entreprise: string;
  };
  stage: {
    stageId?: number;
    description: string;
    objective: string;
    entreprise: string;
  };
  periode: {
    periodeId: {
      stage_id: number;
      stagiaire_id: number;
    };
    dateDebut: string;
    dateFin: string;
  };
  appreciation: {
    appreciationId: {
      tuteurId: number;
      periodeId: {
        stage_id: number;
        stagiaire_id: number;
      };
    };
    appreciationName: string;
  };
  evaluations: { categorie: string; valeur: string }[];
  competences: {
    intitule: string;
    note: string;
    categories: { intitule: string; valeur: string }[];
  }[];
}
