import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../../categoria/categoria.model';
import { CategoriaService } from '../../categoria/categoria.service';
import { Conto } from '../conto.model';
import { ContoService } from '../conto.service';

@Component({
  selector: 'app-conto-read-all',
  templateUrl: './conto-read-all.component.html',
  styleUrls: ['./conto-read-all.component.css']
})
export class ContoReadAllComponent implements OnInit {

  contos: Conto[] = []

  displayedColumns: string[] = ['id', 'titulo', 'contos', 'acoes']

  id_categoria: String = ''

  categoria: Categoria = {
    id: '',
    nome: '',
    descricao: ''
  }

  constructor(private service: ContoService, private route: ActivatedRoute, private router: Router, private serviceCategoria: CategoriaService) { }

  ngOnInit(): void {
    this.id_categoria = this.route.snapshot.paramMap.get('id_categoria')!
    this.findAll()
    this.findByidCategoria()
  }

  findByidCategoria(): void {
    this.serviceCategoria.findById(this.id_categoria || '').subscribe((resposta) => {
      this.categoria = resposta
      console.log(this.categoria)
    })
  }

  findAll(): void {
    this.service.findAllByCategoria(this.id_categoria).subscribe((resposta) => {
      this.contos = resposta;
      console.log(resposta);
      
    })
  }

  navegarParaCriarConto(): void {
    this.router.navigate([`categorias/${this.id_categoria}/contos/create`])
  }

}
