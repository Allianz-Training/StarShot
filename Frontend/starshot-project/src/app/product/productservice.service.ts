import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {} from 'rxjs/add/operator/map';
@Injectable({
  providedIn: 'root'
})
export class ProductserviceService {

  getAll_API = 'http://localhost:8080/getevent';
  getMusic_API = 'http://localhost:8080/getevent/music/upcoming';
  getSports_API = 'http://localhost:8080/getevent/sport/upcoming';
  getConference_API = 'http://localhost:8080/getevent/conference/upcoming';

  constructor(private http: HttpClient) {}

  getAll(){
    return this.http.get<any>(`${this.getAll_API}`);
  }
  getUpcomingMusic(){
    return this.http.get(this.getMusic_API);
  }
  getUpcomingSports(){
    return this.http.get<any>(`${this.getMusic_API}`);
  }
  getUpcomingConference(){
    return this.http.get<any>(`${this.getConference_API}`);
  }
}
