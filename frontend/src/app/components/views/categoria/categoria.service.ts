import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import type { Categoria } from 'src/app/components/views/categoria/categoria.model';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  baseUrl: String = environment.baseUrl;

  constructor(private http: HttpClient, private _snack: MatSnackBar) { }

  findAll(): Observable<Categoria[]> {
    const url = `${this.baseUrl}/categorias`
    return this.http.get<Categoria[]>(url)
  }

  findById(id: String): Observable<Categoria> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.http.get<Categoria>(url)
  }

  create(categoria: Categoria): Observable<Categoria> {
    const url = `${this.baseUrl}/categorias`
    return this.http.post<Categoria>(url, categoria)
  }

  update(id: String, categoria: Categoria): Observable<void> {
    const url = `${this.baseUrl}/categorias/${id}`
    return this.http.put<void>(url, categoria)
  }

  delete(id: String): Observable<void> { 
    const url = `${this.baseUrl}/categorias/${id}`
    return this.http.delete<void>(url)
  }

  mensagem(str: String): void {
    this._snack.open(`${str}`, 'OK', {
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      duration: 3000
    })
  }
}
