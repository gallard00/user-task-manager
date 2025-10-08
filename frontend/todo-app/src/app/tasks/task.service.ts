import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface TaskDto {
  id: number;
  title: string;
  description?: string;
  completed: boolean;
}

@Injectable({ providedIn: 'root' })
export class TaskService {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/api/tasks';

  list() { return this.http.get<TaskDto[]>(this.baseUrl); }
  create(body: { title: string; description?: string }) { return this.http.post<TaskDto>(this.baseUrl, body); }
  toggle(id: number) { return this.http.patch<TaskDto>(`${this.baseUrl}/${id}/status`, {}); }
  remove(id: number) { return this.http.delete<void>(`${this.baseUrl}/${id}`); }
}
