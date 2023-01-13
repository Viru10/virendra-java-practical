import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewAppoitmentComponent } from './new-appoitment.component';

describe('NewAppoitmentComponent', () => {
  let component: NewAppoitmentComponent;
  let fixture: ComponentFixture<NewAppoitmentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewAppoitmentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewAppoitmentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
