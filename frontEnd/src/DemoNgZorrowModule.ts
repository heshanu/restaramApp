import { NgModule } from '@angular/core';
import { NzBackTopModule } from 'ng-zorro-antd/back-top';
import { NzFormModule } from 'ng-zorro-antd/form';
import { NzInputModule } from 'ng-zorro-antd/input';
import { NzButtonModule } from 'ng-zorro-antd/button';
@NgModule({
    exports: [NzBackTopModule, NzFormModule,NzInputModule,NzButtonModule]
})
export class DemoNgZorroAntdModule { }