import { Component, OnInit } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
import { Eventdata } from '../product-music/eventdata.model';
import { map } from 'rxjs/operators';

interface apidata{
  event_type: string,
  event_name: string,
  event_date: Date,
  event_location: string,
  package_a_price: number
}
@Component({
  selector: 'app-product-music',
  templateUrl: './product-music.component.html',
  styleUrls: ['./product-music.component.css'],
})

export class ProductMusicComponent implements OnInit {
  musicUrl = 'http://localhost:8080/getevent';
  registerUrl = 'http://localhost:8080/postregistration';
  responseValue: any;
  eventList:any;
  closeResult = '';
  public form: FormGroup;
  public api_data : apidata[];


  constructor(
    private http: HttpClient,
    private modalService: NgbModal,
    private formBuilder: FormBuilder
  ) {
    this.form = this.formBuilder.group({
      policy_number: [null],
      event_code: [null],
      title_name: ['', Validators.required],
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      national_id: ['', Validators.required],
      passport_number: [''],
      gender: ['', Validators.required],
      birth_date: ['', Validators.required],
      phone_number: ['', Validators.required],
      email: ['', Validators.required],
      nationality: ['', Validators.required],
      address: ['', Validators.required],
      totle_price: [null]
    });
  }
  ngOnInit(){
    this.getMusic();
  }
  getMusic() {
    this.http.get<{[key: string]: apidata}>(this.musicUrl).pipe(map(data => {
      const eventdata =[];
      for (const key in data){
        if(data.hasOwnProperty(key)){
          eventdata.push(
            new Eventdata(
              data[key].event_type,
              data[key].event_name,
              data[key].event_date,
              data[key].event_location,
              data[key].package_a_price
            ))
        }}
        return eventdata;
    })).subscribe((eventdata) => {
      console.log(eventdata);
      this.eventList = eventdata;
    });
  }
  open(content) {
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  onSubmitForm() {
    let data = this.form.value;
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    this.http.post(this.registerUrl, data, { headers: headers }).subscribe(
      (result) => {
        this.responseValue = result;
        console.log(result);
      },
      (err: HttpErrorResponse) => {
        // กรณี error
        if (err.error instanceof Error) {
          // กรณี error ฝั่งผู้ใช้งาน หรือ การเชื่อมต่อเกิด error ขึ้น
          console.log('An error occurred:', err.error.message);
        } else {
          // กรณี error ฝั่ง server ไม่พบไฟล์ ,server error
          console.log(
            `Backend returned code ${err.status}, body was: ${err.error}`
          );
        }
      }
    );
    console.log(this.form.value);
    this.form.reset();
  }
}
