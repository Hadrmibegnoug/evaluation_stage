import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TbEvaluationStagiaireComponent } from './tb-evaluation-stagiaire.component';

describe('TbEvaluationStagiaireComponent', () => {
  let component: TbEvaluationStagiaireComponent;
  let fixture: ComponentFixture<TbEvaluationStagiaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TbEvaluationStagiaireComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TbEvaluationStagiaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
