import { NgModule } from '@angular/core';
import { NzBackTopModule } from 'ng-zorro-antd/back-top';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { NzPageHeaderModule } from 'ng-zorro-antd/page-header';
@NgModule({
    exports: [NzBackTopModule, NzFormModule,NzInputModule,NzButtonModule,NzPageHeaderModule]
})
export class DemoNgZorroAntdModule { }