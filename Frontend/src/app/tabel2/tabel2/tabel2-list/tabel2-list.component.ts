import { Component, OnInit,inject } from '@angular/core';
import { Tabel2ListBaseComponent } from '@baseapp/tabel2/tabel2/tabel2-list/tabel2-list.base.component';
import { Tabel2Service } from '@baseapp/tabel2/tabel2/tabel2.service';


@Component({
  selector: 'app-tabel2-list',
  templateUrl: '../../../../../base/app/tabel2/tabel2/tabel2-list/tabel2-list.component.html',
  styleUrls: ['./tabel2-list.scss']
})
export class Tabel2ListComponent extends Tabel2ListBaseComponent implements OnInit {
 
	
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