import { Injectable } from '@angular/core';

const TOKEN = "token";
const USER="user details";

@Injectable({
  providedIn: 'root'
})
export class StorageService {

  constructor() { }

  public saveToken(token:any):void { 
    window.localStorage.removeItem(TOKEN);
    window.localStorage.setItem(TOKEN, token);
    console.log(localStorage.getItem(TOKEN));
  }

  public saveUser(user:any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER, JSON.stringify(user));
  }
}
