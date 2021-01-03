import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-product-conference',
  templateUrl: './product-conference.component.html',
  styleUrls: ['./product-conference.component.css']
})
export class ProductConferenceComponent implements OnInit {
  conferenceUrl = 'http://localhost:8080/getevent/conference/upcoming';
  eventList=[]; 
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
    this.getConference();
  }
  getConference(){
    this.http.get<any>(this.conferenceUrl).subscribe(res => {
      console.log(res) 
      this.eventList =res; 
    }); 
  }
}
