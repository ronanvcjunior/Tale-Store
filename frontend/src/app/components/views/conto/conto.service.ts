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

  findById(id: String): Observable<Conto> {
    const url = `${this.baseUrl}/contos/${id}`
    return this.http.get<Conto>(url)
  }

  findAllByCategoria(id_categoria: String): Observable<Conto[]> {
    const url = `${this.baseUrl}/contos?categoria=${id_categoria}`
    return this.http.get<Conto[]>(url)
  }

  create(id_categoria: String, conto: Conto): Observable<Conto> {
    const url = `${this.baseUrl}/contos?categoria=${id_categoria}`
    return this.http.post<Conto>(url, conto)
  }

  update(conto: Conto): Observable<Conto> {
    const url = `${this.baseUrl}/contos/${conto.id}`
    return this.http.patch<Conto>(url, conto)
  }

  mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      duration: 3000
    })
  }
}
