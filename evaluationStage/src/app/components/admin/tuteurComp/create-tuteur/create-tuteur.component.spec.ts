import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateTuteurComponent } from './create-tuteur.component';

describe('CreateTuteurComponent', () => {
  let component: CreateTuteurComponent;
  let fixture: ComponentFixture<CreateTuteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreateTuteurComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateTuteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
