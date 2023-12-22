import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../service/admin.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { NzMessageService } from 'ng-zorro-antd/message';
import { NzNotificationService } from 'ng-zorro-antd/notification';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrl: './add-category.component.css',
})
export class AddCategoryComponent implements OnInit {
  
  constructor(private message: NzMessageService,
    private notification: NzNotificationService,
    private adminService: AdminService, private fb: FormBuilder) { }
  
  validateForm!: FormGroup;
  selectedFile!: File | null;
  imagePreview!: string|ArrayBuffer|null|any;

  ngOnInit(): void {
    this.validateForm = this.fb.group({
      name: ['', [Validators.required]],
      description: ['', [Validators.required]],
      img: ['', []],
    });
  }
  
  submitForm(): void {
    if (this.validateForm.valid) {
      console.log(this.validateForm.value);
      const formData = new FormData();
      formData.append('name', this.validateForm.value.name);
      formData.append('description', this.validateForm.value.description);
      formData.append('img', this.imagePreview);

      this.adminService.postCategory(this.validateForm.value).subscribe(
        (res) => {
          if (res.id != null) {
            console.log(res);
            this.notification.success('Success', 'Category Inserted Success', { nzDuration: 4000 });
          }
},
        (err) => {
          console.log(err.value);
          this.notification.error('Error', 'Category Inserted Failed', { nzDuration: 4000 });
        }
      )

    } else {
      Object.values(this.validateForm.controls).forEach(control => {
        if (control.invalid) {
          control.markAsDirty();
          control.updateValueAndValidity({ onlySelf: true });
        }
      });
      this.notification.error('Error', 'Sign Up Failed', { nzDuration: 4000 });
    }
    this.validateForm.reset();
  }

  onFileSelected(event:any) { 
    this.selectedFile = <File>event?.target?.files[0];
    this.previewImage();
  }

  previewImage() { 
    const reader = new FileReader();
    reader.onload = () => {
      this.imagePreview = reader.result;
    };
    reader.readAsDataURL(this.selectedFile!);
  }

}
