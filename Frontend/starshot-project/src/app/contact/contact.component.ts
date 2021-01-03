import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.css']
})
export class ContactComponent implements OnInit {
  public form: FormGroup;
  responseValue: any;
  postContactusUrl = 'http://localhost:8080/postcontactus';

  constructor(private http: HttpClient
    , private formBuilder: FormBuilder) { 
      this.form = this.formBuilder.group({
        idcontact_us:[''],
        name: ['', Validators.required],
        email: ['', Validators.required],
        phone_number: ['', Validators.required],
        message: ['', Validators.required],
      });
    }

  ngOnInit(): void {
  }
  onSubmitForm() {
    let data = this.form.value;
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    this.http.post(this.postContactusUrl, data, { headers: headers }).subscribe(
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
    alert("Thank you for your feedback!");
    console.log(this.form.value);
    this.form.reset();
  }
}
