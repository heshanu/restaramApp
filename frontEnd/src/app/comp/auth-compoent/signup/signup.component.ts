import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../../service/auth.service';
import { FormBuilder } from '@angular/forms';
import { FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent implements OnInit{
  
  constructor(private authService: AuthService, private fb: FormBuilder) { }
  validateForm!: FormGroup;
  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: ['', [Validators.required]],
      password: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }
 
  // validateForm:FormGroup<{
  //   name: FormControl<string>;
  //   password: FormControl<string>;
  //   email: FormControl<string>;
  // }> = this.fb.group({
  //   name: ['', [Validators.required]],
  //   password: ['', [Validators.required]],
  //   email: ['', [Validators.required]]
  // });

  submitForm(): void {
    if (this.validateForm.valid) {
      console.log('submit', this.validateForm.value);
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
