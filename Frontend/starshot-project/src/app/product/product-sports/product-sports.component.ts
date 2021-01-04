import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
@Component({
  selector: 'app-product-sports',
  templateUrl: './product-sports.component.html',
  styleUrls: ['./product-sports.component.css']
})
export class ProductSportsComponent implements OnInit {
  sportUrl = 'http://localhost:8080/getevent';
  registerUrl = 'http://localhost:8080/postregistration';
  responseValue: any;
  eventList:any = [];
  closeResult = '';
  public form: FormGroup;

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
      email: ['', [Validators.required,Validators.email]],
      nationality: ['', Validators.required],
      address: ['', Validators.required],
      total_price: ['']
    });
  }
  ngOnInit(){
    this.getMusic();
  }
  getMusic() {
    this.http.get<any>(this.sportUrl).subscribe(res => {
      console.log(res) 
      this.eventList =res; 
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
  onAgree(){
    alert("Please check your information before submit\n" 
    +"Full name: "+this.form.value.first_name+" "+this.form.value.last_name + 
    "\nEmail: "+ this.form.value.email + " Phone No: "+ this.form.value.phone_number
    +" \nTotal price: "+ this.form.value.total_price)+" baht";
  }
  openSecond(content) {
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
}
