import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormBuilder } from '@angular/forms';
@Component({
  selector: 'app-claim',
  templateUrl: './claim.component.html',
  styleUrls: ['./claim.component.css'],
})
export class ClaimComponent implements OnInit {
  public form: FormGroup;
  postClaimUrl = 'http://localhost:8080/postclaim';
  responseValue: any;

  constructor(private http: HttpClient
    , private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      policy_number: ['', Validators.required],
      first_name: ['', Validators.required],
      last_name: ['', Validators.required],
      phone_number: ['', Validators.required],
      email: ['', Validators.required],
      incident: ['', Validators.required],
    });
  }

  ngOnInit(): void {}
  
  onSubmitForm() {
    let data = this.form.value;
    const headers = new HttpHeaders();
    headers.append('Content-Type', 'application/json');
    this.http.post(this.postClaimUrl, data, { headers: headers }).subscribe(
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
    alert("Done! We will contact you back as soon as possible");
    console.log(this.form.value);
    this.form.reset();
  }
}
