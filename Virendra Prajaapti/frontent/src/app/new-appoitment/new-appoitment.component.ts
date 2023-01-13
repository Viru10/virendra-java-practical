import { Component, OnInit } from '@angular/core';
import { AppServices } from '../app.service';

@Component({
  selector: 'app-new-appoitment',
  templateUrl: './new-appoitment.component.html',
  styleUrls: ['./new-appoitment.component.scss'],
})
export class NewAppoitmentComponent implements OnInit {
  doctorList: any[] = [];
  doctorId: number | any;
  doctorSpec: string = '';

  constructor(private appServices: AppServices) {}

  ngOnInit(): void {
    this.getListOfAppoitments();
  }

  getListOfAppoitments() {
    this.appServices.getAllDoctors().subscribe((res) => {
      this.doctorList = res;
    });
  }

  selectDoctorDetails(doctorDetails: any) {
    this.doctorId = doctorDetails.target.value;
    let data = this.doctorList.find((item: any) => item.doctorId === this.doctorId);
  }
}
