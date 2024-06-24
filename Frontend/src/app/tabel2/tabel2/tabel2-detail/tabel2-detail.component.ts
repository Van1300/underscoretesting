import { Component, OnInit,inject } from '@angular/core';
import { Tabel2DetailBaseComponent } from '@baseapp/tabel2/tabel2/tabel2-detail/tabel2-detail.base.component';
import { Tabel2Service } from '@baseapp/tabel2/tabel2/tabel2.service';


@Component({
  selector: 'app-tabel2-detail',
  templateUrl: '../../../../../base/app/tabel2/tabel2/tabel2-detail/tabel2-detail.component.html',
  styleUrls: ['./tabel2-detail.scss']
})
export class Tabel2DetailComponent extends Tabel2DetailBaseComponent implements OnInit {
 
	
  ngAfterViewInit(): void {
    this.onAfterViewInit()
  }

  ngOnInit(): void {
    super.onInit();
  }

  ngOnChanges(changes:any){
    super.onChanges(changes);
  }
 
}