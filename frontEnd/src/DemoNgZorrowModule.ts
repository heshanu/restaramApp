import { NgModule } from '@angular/core';
import { NzBackTopModule } from 'ng-zorro-antd/back-top';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';
import { NzNotificationModule } from 'ng-zorro-antd/notification';
import { NzSpinModule } from 'ng-zorro-antd/spin';
import { NzMessageModule } from 'ng-zorro-antd/message';

@NgModule({
    exports: [NzBackTopModule,
        NzMessageModule,
        NzFormModule,
        NzInputModule,
        NzSpinModule,
        NzNotificationModule,
        NzButtonModule,
        NzPageHeaderModule
    ]
})
export class DemoNgZorroAntdModule { }