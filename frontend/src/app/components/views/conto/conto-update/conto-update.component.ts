import { Component, OnInit } from '@angular/core';
import { FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../../categoria/categoria.model';
import { CategoriaService } from '../../categoria/categoria.service';
import { Conto } from '../conto.model';
import { ContoService } from '../conto.service';

@Component({
  selector: 'app-conto-update',
  templateUrl: './conto-update.component.html',
  styleUrls: ['./conto-update.component.css']
})
export class ContoUpdateComponent implements OnInit {

  conto: Conto = {
    titulo: '',
    nomeAutor: '',
    texto: ''
  }

  id_categoria: String = ''

  titulo = new FormControl('', [Validators.minLength(3)])

  nomeAutor = new FormControl('', [Validators.minLength(3)])

  texto = new FormControl('', [Validators.minLength(10)])

  categoria: Categoria = {
    id: '',
    nome: '',
    descricao: ''
  }

  constructor(private service: ContoService, private route: ActivatedRoute, private router: Router, private serviceCategoria: CategoriaService) { }

  ngOnInit(): void {
    this.id_categoria = this.route.snapshot.paramMap.get('id_categoria')!
    this.findByidCategoria()
    this.conto.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById():void {
    this.service.findById(this.conto.id!).subscribe((resposta) => {
      this.conto = resposta
    })
  }

  findByidCategoria(): void {
    this.serviceCategoria.findById(this.id_categoria || '').subscribe((resposta) => {
      this.categoria = resposta
      console.log(this.categoria)
    })
  }

  getMessage(field: string) {
    let anyInvalid = this.titulo.invalid || this.texto.invalid || this.nomeAutor.invalid;

    if (this.titulo.invalid && field == "titulo") {
      return "O campo TITULO deve ter entre 3 e 50 caracteres"
    }

    if (this.nomeAutor.invalid && field == "nomeAutor") {
      return "O campo NOME DO(A) AUTOR(A) deve ter entre 3 e 50 caracteres"
    }

    if (this.texto.invalid && field == "texto") {
      return "O campo TEXTO deve ter entre 10 e 50 caracteres"
    }

    if (anyInvalid && field == "button") {
      return true
    }
    return false
  }

  update(): void {
    this.service.update(this.conto).subscribe((resposta) => {
      this.router.navigate([`categorias/${this.id_categoria}/contos`])
      this.service.mensagem('Conto editado com sucesso!')
      console.log(resposta);
      
    }, err => {
      this.router.navigate([`categorias/${this.id_categoria}/contos`])
      this.service.mensagem('Não foi possível editar o conto! Tente mais tarde!')
    })
  }

  cancel(): void {
    this.router.navigate([`categorias/${this.id_categoria}/contos`])
  }

}
