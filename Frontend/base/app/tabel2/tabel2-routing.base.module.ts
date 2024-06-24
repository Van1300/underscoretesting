import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CanDeactivateGuard } from '@baseapp/auth.can-deactivate-guard.service';

import { Tabel2ListComponent } from '@app/tabel2/tabel2/tabel2-list/tabel2-list.component';
import { Tabel2DetailComponent } from '@app/tabel2/tabel2/tabel2-detail/tabel2-detail.component';

export const routes: Routes = [

{
     path: 'tabel2list',
     component: Tabel2ListComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "TABEL2_LIST",
        breadcrumb: "TABEL2_LIST",
        roles : [
        			"App Admin",
				    "Development Administrator"
]
     }
},
{
     path: 'tabel2detail',
     component: Tabel2DetailComponent,
     canDeactivate: [ CanDeactivateGuard ],
     data: {
     	label: "TABEL2_DETAIL",
        breadcrumb: "TABEL2_DETAIL",
        roles : [					"all"
				]
     }
}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class Tabel2BaseRoutingModule
{
}
