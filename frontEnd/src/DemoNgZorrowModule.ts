import { NgModule } from '@angular/core';
import { NzBackTopModule } from 'ng-zorro-antd/back-top';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';
import { NzNotificationModule } from 'ng-zorro-antd/notification';


@NgModule({
    exports: [NzBackTopModule, NzFormModule,NzInputModule, NzNotificationModule,NzButtonModule,NzPageHeaderModule]
})
export class DemoNgZorroAntdModule { }