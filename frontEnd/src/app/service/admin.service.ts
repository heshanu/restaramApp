import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { StorageService } from './storage.service';
const BASIC_URL = 'http://localhost:8080/api/v1/admin';
@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http: HttpClient,private storageSerivice:StorageService) { }
  
  public postCategory(categoryDto: any): Observable<any> {
    return this.http.post(`${BASIC_URL}/category`, categoryDto,
      {
        headers:this.createAuthorizationHeader()
      }); 
  }

  public createAuthorizationHeader():HttpHeaders{
    let authHeaders: HttpHeaders = new HttpHeaders();
    console.log(`toe`, this.storageSerivice.getToeken());
    return authHeaders.append('Authorization', 'Bearer ' +this.storageSerivice.getToeken() );
  }


}
