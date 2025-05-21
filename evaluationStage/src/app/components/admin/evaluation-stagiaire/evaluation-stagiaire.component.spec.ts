import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EvaluationStagiaireComponent } from './evaluation-stagiaire.component';

describe('EvaluationStagiaireComponent', () => {
  let component: EvaluationStagiaireComponent;
  let fixture: ComponentFixture<EvaluationStagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [EvaluationStagiaireComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EvaluationStagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
