import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SignupComponent } from './comp/auth-compoent/signup/signup.component';
import { LoginComponent } from './comp/auth-compoent/login/login.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/welcome' },
  { path: 'signUp', component: SignupComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', loadChildren: () => import('./modules/admin/admin.module').then(m => m.AdminModule) },
  {path: 'customer', loadChildren: () => import('./modules/customer/customer.module').then(m => m.CustomerModule)},
  { path: 'welcome', loadChildren: () => import('./pages/welcome/welcome.module').then(m => m.WelcomeModule) }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
