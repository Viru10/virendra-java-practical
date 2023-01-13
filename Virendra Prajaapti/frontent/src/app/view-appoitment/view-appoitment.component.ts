import { Component, OnInit } from '@angular/core';
import { AppServices } from '../app.service';

@Component({
  selector: 'app-view-appoitment',
  templateUrl: './view-appoitment.component.html',
  styleUrls: ['./view-appoitment.component.scss'],
})
export class ViewAppoitmentComponent implements OnInit {
  appoitmentList: any = [];
  constructor(private appServices: AppServices) {}
  ngOnInit(): void {
    this.getListOfAppoitments();
  }

  getListOfAppoitments() {
    this.appServices.getAllAppoitment().subscribe((res) => {
      console.log('res: ', res);
      this.appoitmentList = res;
    });
  }
}
