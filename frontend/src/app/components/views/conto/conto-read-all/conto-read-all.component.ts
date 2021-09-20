import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
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

  constructor(private service: ContoService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id_categoria = this.route.snapshot.paramMap.get('id_categoria')!
    this.findAll()
  }

  findAll(): void {
    this.service.findAllByCategoria(this.id_categoria).subscribe((resposta) => {
      this.contos = resposta;
      console.log(resposta);
      
    })
  }

}
