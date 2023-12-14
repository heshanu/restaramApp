import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NonNullableFormBuilder, Validators } from '@angular/forms';
import { NzNotificationService } from 'ng-zorro-antd/notification';
import { AuthService } from '../../../service/auth.service';
import {
  CanActivate, Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
}                           from '@angular/router';
import { StorageService } from '../../../service/storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  isSpining: boolean=false;
  
  constructor(private authService: AuthService,private storageService:StorageService,private router:Router,private notification:NzNotificationService,private fb: FormBuilder) { }
  
  validateForm!: FormGroup;
  
  ngOnInit(): void {
    this.validateForm = this.fb.group({
      password: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
  }
 
  submitForm(): void {
    if (this.validateForm.valid) {
      this.isSpining = true;
      console.log('submit', this.validateForm.value);
      this.authService.login(this.validateForm.value)
        .subscribe(
          data => {
            console.log(JSON.stringify(data));
            this.notification.success('Success', 'Login Success', { nzDuration: 4000 });  
            
            const user = {
              id: data.userId,
              role: data.userRole
            };

            this.storageService.saveUser(user);
            this.storageService.saveToken(JSON.stringify(data));

            //this.storageService.saveToken(data.token);
          //this.router.navigate(['/welcome']);
        },
        err => {
          console.log(err);
          this.notification.error('Error', 'Login Failed', {nzDuration: 4000});
        }
      );
      this.isSpining = false;
      this.validateForm.reset();
      //this.storageService.saveToken();

    } else {
              this.isSpining = false;
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
    }
  }
  
}
