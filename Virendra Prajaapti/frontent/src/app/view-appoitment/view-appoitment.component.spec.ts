import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAppoitmentComponent } from './view-appoitment.component';

describe('ViewAppoitmentComponent', () => {
  let component: ViewAppoitmentComponent;
  let fixture: ComponentFixture<ViewAppoitmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAppoitmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewAppoitmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
