import { Routes } from '@angular/router';
import { Login } from './auth/login/login';
import { Register } from './auth/register/register';
import { TaskList } from './tasks/task-list/task-list';
import { TaskForm } from './tasks/task-form/task-form';
import { authGuard } from './core/interceptors/auth.guard';

export const routes: Routes = [
    { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
    { path: 'auth/login', component: Login },
    { path: 'auth/register', component: Register },
    { path: 'tasks', component: TaskList, canActivate: [authGuard] },
    { path: 'tasks/new', component: TaskForm, canActivate: [authGuard] },
    { path: '**', redirectTo: 'auth/login' }
];
