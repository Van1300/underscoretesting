import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Tabel2RoutingModule } from './tabel2-routing.module';
import { Tabel2BaseModule } from '@baseapp/tabel2/tabel2.base.module';
@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    Tabel2BaseModule,
    Tabel2RoutingModule
    
  ],
  exports: [
      Tabel2BaseModule,
  ]

})
export class Tabel2Module  { }