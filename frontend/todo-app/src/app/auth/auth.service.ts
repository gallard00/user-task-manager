import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/api/auth'; // tu backend Spring Boot

  // ✅ Guardar token usando Signal
  token = signal<string | null>(localStorage.getItem('token'));

  login(email: string, password: string) {
    return this.http.post<{ token: string }>(`${this.baseUrl}/login`, { email, password });
  }

  register(name: string, email: string, password: string) {
    return this.http.post(`${this.baseUrl}/register`, { name, email, password });
  }

  saveToken(token: string) {
    this.token.set(token);
    localStorage.setItem('token', token);
  }

  logout() {
    this.token.set(null);
    localStorage.removeItem('token');
  }
}
