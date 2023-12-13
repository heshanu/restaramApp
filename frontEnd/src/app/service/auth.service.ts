import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../shared/interface/user';


const API_URL = 'http://localhost:8080/api/v1/auth';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  
  signUp(signupRequest: User): Observable<User>{ 
    console.log(`signUp authService`);
    return this.http.post<User>(API_URL + '/signIn', signupRequest);
  }
}
