import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriaCreateComponent } from './components/views/categoria/categoria-create/categoria-create.component';
import { CategoriaDeleteComponent } from './components/views/categoria/categoria-delete/categoria-delete.component';
import { CategoriaReadComponent } from './components/views/categoria/categoria-read/categoria-read.component';
import { CategoriaUpdateComponent } from './components/views/categoria/categoria-update/categoria-update.component';
import { ContoCreateComponent } from './components/views/conto/conto-create/conto-create.component';
import { ContoDeleteComponent } from './components/views/conto/conto-delete/conto-delete.component';
import { ContoReadAllComponent } from './components/views/conto/conto-read-all/conto-read-all.component';
import { ContoReadComponent } from './components/views/conto/conto-read/conto-read.component';
import { ContoUpdateComponent } from './components/views/conto/conto-update/conto-update.component';
import { HomeComponent } from './components/views/home/home.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'categorias',
    component: CategoriaReadComponent
  },
  {
    path: 'categorias/create',
    component: CategoriaCreateComponent
  },
  {
    path: 'categorias/delete/:id',
    component: CategoriaDeleteComponent
  },
  {
    path: 'categorias/update/:id',
    component: CategoriaUpdateComponent
  },
  {
    path: 'categorias/:id_categoria/contos',
    component: ContoReadAllComponent
  },
  {
    path: 'categorias/:id_categoria/contos/create',
    component: ContoCreateComponent
  },
  {
    path: 'categorias/:id_categoria/contos/:id/update',
    component: ContoUpdateComponent
  },
  {
    path: 'categorias/:id_categoria/contos/:id/delete',
    component: ContoDeleteComponent
  },
  {
    path: 'categorias/:id_categoria/contos/:id/read',
    component: ContoReadComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
