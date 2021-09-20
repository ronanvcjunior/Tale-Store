import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../../categoria/categoria.model';
import { CategoriaService } from '../../categoria/categoria.service';
import { Conto } from '../conto.model';
import { ContoService } from '../conto.service';

@Component({
  selector: 'app-conto-delete',
  templateUrl: './conto-delete.component.html',
  styleUrls: ['./conto-delete.component.css']
})
export class ContoDeleteComponent implements OnInit {

  conto: Conto = {
    titulo: '',
    nomeAutor: '',
    texto: ''
  }

  id_categoria: String = ''

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

  findById(): void {
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

  delete(): void {
    this.service.delete(this.conto.id!).subscribe((resposta) => {
      this.router.navigate([`categorias/${this.id_categoria}/contos`])
      this.service.mensagem('Livro deletado com sucesso!')
    }, err => {
      this.router.navigate([`categorias/${this.id_categoria}/contos`])
      this.service.mensagem('Falhou ao deletar conto! Tente mais tarde!')
    })
  }

  cancel(): void {
    this.router.navigate([`categorias/${this.id_categoria}/contos`])
  }

}

