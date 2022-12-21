import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Address } from './address';
import { HttpClient, HttpResponse } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class AddressService {

  constructor(private http: HttpClient) {}
  private baseURL = "http://localhost:8080/address";
  
//get
getAddressList(): Observable<Address[]>{
  return this.http.get<Address[]>(`${this.baseURL}`);
}
//save
public addAddress(address:any){
  return this.http.post(`${this.baseURL}`,address);
    
  }

//delete address
public deleteAddress(id:any){
return this.http.delete(`${this.baseURL}/${id}`);
}
//single quiz

public getAddressById(id:any){
  return this.http.get(`${this.baseURL}/byId/${id}`);
}
}

