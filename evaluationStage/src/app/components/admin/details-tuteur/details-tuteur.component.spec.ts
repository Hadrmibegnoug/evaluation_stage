import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailsTuteurComponent } from './details-tuteur.component';

describe('DetailsTuteurComponent', () => {
  let component: DetailsTuteurComponent;
  let fixture: ComponentFixture<DetailsTuteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailsTuteurComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DetailsTuteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
