import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class VehicleService {

  constructor(private http: HttpClient) { }

  getVehicles(q: string): Observable<VehicleResponse[]> {
    const params = new HttpParams().append('q', q);
    return this.http.get<VehicleResponse[]>(`http://localhost:8080/api/vehicles`, { params: params })
  }

  create(request: any): Observable<VehicleResponse> {
    return this.http.post<VehicleResponse>(`http://localhost:8080/api/vehicles`, request);
  }

  edit(id: string, request: any): Observable<any> {
    return this.http.put(`http://localhost:8080/api/vehicles/${id}`, request);
  }

  updateVehicle(id: string, request: any): Observable<any> {
    return this.http.patch(`http://localhost:8080/api/vehicles/${id}`, request);
  }

  deleteVehicle(id: string): Observable<any> {
    return this.http.delete(`http://localhost:8080/api/vehicles/${id}`);
  }

}