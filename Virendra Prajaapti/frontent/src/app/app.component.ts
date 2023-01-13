import { Component, OnInit } from '@angular/core';
import { AppServices } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  ngOnInit(): void {
  }
  title = 'my-app';
}
