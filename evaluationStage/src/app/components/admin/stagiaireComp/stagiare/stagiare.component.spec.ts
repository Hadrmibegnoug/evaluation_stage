import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StagiareComponent } from './stagiare.component';

describe('StagiareComponent', () => {
  let component: StagiareComponent;
  let fixture: ComponentFixture<StagiareComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [StagiareComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StagiareComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
