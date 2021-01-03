import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-product-sports',
  templateUrl: './product-sports.component.html',
  styleUrls: ['./product-sports.component.css']
})
export class ProductSportsComponent implements OnInit {
  sportUrl = 'http://localhost:8080/getevent/sport/upcoming';
  eventList=[]; 
  constructor(private http : HttpClient) { }

  ngOnInit(): void {
    this.getSport();
  }
  getSport(){
    this.http.get<any>(this.sportUrl).subscribe(res => {
      console.log(res) 
      this.eventList =res; 
    }); 
  }
}
