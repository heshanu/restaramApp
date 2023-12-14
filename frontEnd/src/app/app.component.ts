import { Component, OnInit } from '@angular/core';
import { StorageService } from './service/storage.service';
import { Router } from '@angular/router';
import { get } from 'http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  constructor(private router: Router, private storageService: StorageService) { }

  ngOnInit(): void {
  
  this.getAdmin();
  }
 
  isCollapsed = false;
  isAdmin: boolean = true;
  admin: string | null = "";

  public getAdmin():void {
    this.admin =JSON.parse(localStorage.getItem("token") || "")["userRole"]  

    if (this.admin === "ADMIN") {
      this.isAdmin = true;
    }
    else { 
      this.isAdmin = false;
    }
   }

  signOut(): void {
    this.storageService.signOut();
    this.router.navigate(['/login']);
  }
}
