import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IconsProviderModule } from './icons-provider.module';
import { NzLayoutModule } from 'ng-zorro-antd/layout';
import { NzMenuModule } from 'ng-zorro-antd/menu';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { ja_JP } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import ja from '@angular/common/locales/ja';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SignupComponent } from './comp/auth-compoent/signup/signup.component';
import { AuthService } from './service/auth.service';
import { NzButtonModule } from 'ng-zorro-antd/button';
import { DemoNgZorroAntdModule } from '../DemoNgZorrowModule';
import { LoginComponent } from './comp/auth-compoent/login/login.component';

registerLocaleData(ja);

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    IconsProviderModule,
    NzLayoutModule,
    NzMenuModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    HttpClientModule,
    DemoNgZorroAntdModule,
    FormsModule,ReactiveFormsModule
  ],
  providers: [
    AuthService,
    provideClientHydration(),
    { provide: NZ_I18N, useValue: ja_JP }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
