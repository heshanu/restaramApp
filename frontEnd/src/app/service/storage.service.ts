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
    window.localStorage.setItem(TOKEN,JSON.stringify(token));
  }

  public saveUser(user:any): void {
    window.localStorage.removeItem(USER);
    window.localStorage.setItem(USER,JSON.stringify(user));
  }

  public getToeken():string|any {
    let user = JSON.stringify(localStorage.getItem(TOKEN));
    return JSON.parse(user || "")["jwt"];
  }

  public getUser():string{
     let user = JSON.stringify(localStorage.getItem(TOKEN));
    return JSON.parse(user || "")["userId"];
  }
  
  public getUserRole():string{
    let user = localStorage.getItem(TOKEN);
    console.log(`userRole`, JSON.parse(user || "")["userRole"]);
    
    return JSON.parse(user || "")["userRole"];
  }

  public isAdminLoggedIn(): boolean {
    if (this.getUserRole() === "ADMIN") {
      return true;
    }
    return false;
  }

}
