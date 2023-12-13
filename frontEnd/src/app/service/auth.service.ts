import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../shared/interface/user';

const API_URL = 'http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) { }
  
  signUp(signupRequest:User):Observable<User>{ 
    return this.http.post<User>(API_URL + 'api/v1/auth/signUp', signupRequest);
  }
}
