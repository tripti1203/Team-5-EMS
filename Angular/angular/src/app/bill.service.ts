import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bill } from './bill';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  constructor(private http: HttpClient) {
  }
  private baseURL = "http://localhost:8080/bill";
public findAll():
Observable<Bill[]>{
  return this.http.get<Bill[]>("http://localhost:8080/bill");
}


public getById(id:number):Observable<Bill>{
  return this.http.get<Bill>("http://localhost:8080/bill/" + id);
}


public generateBillByConnectionId(id:number,newReading:number) 
{
 // return this.http.put(`${this.baseURL}/${id}/${newReading}`,id,newReading);
 return this.http.put("http://localhost:8080/bill/" + id +"/" + newReading,id);
 
}

public generateBillByMonthAndYear(month:number,year:number):Observable<Bill[]>{
 return this.http.get<Bill[]>("http://localhost:8080/billsMY/"+month+"/"+year);
}

public generateBillByCityAndArea(city:string,area:string):Observable<Bill[]>{
  return this.http.get<Bill[]>("http://localhost:8080/billsAC/"+city+"/"+area);
 }
}
