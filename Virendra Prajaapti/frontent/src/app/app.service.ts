import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environment/environment';

@Injectable({
  providedIn: 'root',
})
export class AppServices {
  private baseURL = environment.baseUrl;
  private url = this.baseURL + '/api/v1';

  constructor(private httpClient: HttpClient) {}

  addAppoitment(appoitmentRequest: any): Observable<any> {
    return this.httpClient.post(this.url + '/add', appoitmentRequest);
  }

  getAllAppoitment(): Observable<any> {
    return this.httpClient.get(this.url + '/getAll');
  }

  updateAppoitment(appoitmentRequest: any): Observable<any> {
    return this.httpClient.patch(this.url + '/edit', appoitmentRequest);
  }
  
  getAllDoctors(): Observable<any> {
    return this.httpClient.get(this.url + '/getAll/doctors');
  }
}
