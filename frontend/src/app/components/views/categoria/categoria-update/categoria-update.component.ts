import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from '../categoria.model';
import { CategoriaService } from '../categoria.service';

@Component({
  selector: 'app-categoria-update',
  templateUrl: './categoria-update.component.html',
  styleUrls: ['./categoria-update.component.css']
})
export class CategoriaUpdateComponent implements OnInit {

  categoria: Categoria = {
    id: '',
    nome: '',
    descricao: ''
  }

  constructor(private service: CategoriaService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.categoria.id = this.route.snapshot.paramMap.get('id') || ''
    this.findByid()
  }

  findByid(): void {
    this.service.findById(this.categoria.id || '').subscribe((resposta) => {
      this.categoria = resposta
      console.log(this.categoria)
    })
  }

  update(): void {
    this.service.update(this.categoria.id || '', this.categoria).subscribe((resposta) => {
      this.router.navigate(['categorias'])
      this.service.mensagem('Categoria modificada com sucesso!')
    }, err => {
      for (let i = 0; i < err.error.errors.length; i++) {
        this.service.mensagem(err.error.errors[i].message)
      }
    })
  }

  cancel(): void {
    this.router.navigate(['categorias'])
  }

}
