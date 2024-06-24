import { NgModule } from '@angular/core';
import { BsModalService } from 'ngx-bootstrap/modal';
import { SharedModule } from '@app/shared/shared.module';
import { WidgetsBaseModule } from '@libbase/widgets.base.module';
import { Table1ListComponent } from '@app/table1/table1/table1-list/table1-list.component';
import { Table1DetailComponent } from '@app/table1/table1/table1-detail/table1-detail.component';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

@NgModule({
  declarations: [
    Table1ListComponent,
    Table1DetailComponent
  ],
  imports: [
    SharedModule,
    WidgetsBaseModule,
  ],
  exports: [
    SharedModule,
	WidgetsBaseModule,
    Table1ListComponent,
    Table1DetailComponent
  ],
  providers: [
  	BsModalService,
	CanDeactivateGuard
  ],
  
})
export class Table1BaseModule { }