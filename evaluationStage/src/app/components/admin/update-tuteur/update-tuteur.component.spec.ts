import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateTuteurComponent } from './update-tuteur.component';

describe('UpdateTuteurComponent', () => {
  let component: UpdateTuteurComponent;
  let fixture: ComponentFixture<UpdateTuteurComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UpdateTuteurComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpdateTuteurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
