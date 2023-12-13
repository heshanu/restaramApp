import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../service/auth.service';
import { FormBuilder } from '@angular/forms';
import { FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit{

  isSpining!: boolean;
  
  constructor(private authService: AuthService,private notification:NzNotificationService,private fb: FormBuilder) { }
  validateForm!: FormGroup;
  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: ['', [Validators.required]],
      password: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }
 
  submitForm(): void {
    if (this.validateForm.valid) {
      console.log('submit', this.validateForm.value);
      this.authService.signUp(this.validateForm.value).subscribe(
        data => {
          console.log(data);
          this.notification.success('Success', 'Sign Up Success', {nzDuration: 4000});
          
        },
        err => {
          console.log(err);
          this.notification.error('Error', 'Sign Up Failed', {nzDuration: 4000});
        }
      );

    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }

  

}
