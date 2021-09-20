import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Conto } from '../conto.model';
import { ContoService } from '../conto.service';

@Component({
  selector: 'app-conto-read',
  templateUrl: './conto-read.component.html',
  styleUrls: ['./conto-read.component.css']
})
export class ContoReadComponent implements OnInit {

  conto: Conto = {
    titulo: '',
    nomeAutor: '',
    texto: ''
  }

  id_categoria: String = ''

  constructor(private service: ContoService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id_categoria = this.route.snapshot.paramMap.get('id_categoria')!
    this.conto.id = this.route.snapshot.paramMap.get('id')!
    this.findById()
  }

  findById(): void {
    this.service.findById(this.conto.id!).subscribe((resposta) => {
      this.conto = resposta
      console.log(resposta);
      
    })
  }

  voltar(): void {
    this.router.navigate([`categorias/${this.id_categoria}/contos`])
  }

}
