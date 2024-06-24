import { NgModule } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { Tabel2ListComponent } from '@app/tabel2/tabel2/tabel2-list/tabel2-list.component';
import { Tabel2DetailComponent } from '@app/tabel2/tabel2/tabel2-detail/tabel2-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

@NgModule({
  declarations: [
    Tabel2ListComponent,
    Tabel2DetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    Tabel2ListComponent,
    Tabel2DetailComponent
  ],
  providers: [
  	BsModalService,
	CanDeactivateGuard
  ],
  
})
export class Tabel2BaseModule { }