import { Routes } from '@angular/router';
import { Login } from './auth/login/login';
import { Register } from './auth/register/register';
import { TaskList } from './tasks/task-list/task-list';
import { TaskForm } from './tasks/task-form/task-form';

export const routes: Routes = [
    { path: '', redirectTo: 'auth/login', pathMatch: 'full' },
    { path: 'auth/login', component: Login },
    { path: 'auth/register', component: Register },
    { path: 'tasks', component: TaskList },
    { path: 'tasks/new', component: TaskForm },
    { path: '**', redirectTo: 'auth/login' }
];
