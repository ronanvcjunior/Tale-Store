import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Conto } from './conto.model';

@Injectable({
  providedIn: 'root'
})
export class ContoService {

  baseUrl: String = environment.baseUrl

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAllByCategoria(id_categoria: String): Observable<Conto[]> {
    const url = `${this.baseUrl}/contos?categoria=${id_categoria}`
    return this.http.get<Conto[]>(url)
  }
}
