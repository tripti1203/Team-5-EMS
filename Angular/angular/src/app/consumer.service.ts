import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Consumer } from './consumer';

@Injectable({
  providedIn: 'root'
})
export class ConsumerService {

  url: string;
  constructor(private http: HttpClient) { 
    this.url = "http://localhost:8080/consumer";
  }

  public findAll():
Observable<Consumer[]>{
  return this.http.get<Consumer[]>("http://localhost:8080/consumer");
}


public getById(id:number):Observable<Consumer>{
  return this.http.get<Consumer>("http://localhost:8080/consumer/" + id);
}


//save
public addConsumer(consumer:any){
 return this.http.post(`${this.url}`,consumer);
  }


public deleteById(id:number):Observable<Consumer>{
  return this.http.delete<Consumer>("http://localhost:8080/consumer/" + id);
}

                                                             
public updatebyId(id:number):Observable<Consumer>{
  return this.http.put<Consumer>("http://localhost:8080/consumer/" + id,{
    "firstName":String,
    "lastName":String
  }
  );
    
}
}
