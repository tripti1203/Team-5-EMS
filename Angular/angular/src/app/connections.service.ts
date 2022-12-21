import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Connections } from './connections';

@Injectable({
  providedIn: 'root'
})
export class ConnectionsService {

  url: string;
  constructor(private http: HttpClient) { 
    this.url = "http://localhost:8080/connections";
  }

  public findAll():
Observable<Connections[]>{
  return this.http.get<Connections[]>("http://localhost:8080/connections");
}


public getById(id:number):Observable<Connections>{
  return this.http.get<Connections>("http://localhost:8080/connections/" + id);
}


//save
public addConnection(connections:any){
 return this.http.post(`${this.url}`,connections);
  }

                                                             
public updatebyId(id:number):Observable<Connections>{
  return this.http.put<Connections>("http://localhost:8080/connections/" + id,{
    "firstName":String,
    "lastName":String
  }
  );
    
}
}
