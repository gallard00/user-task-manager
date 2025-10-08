import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { TaskService } from '../task.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-form.html',
  styleUrl: './task-form.scss'
})
export class TaskForm {
  private api = inject(TaskService);
  private router = inject(Router);
  title = '';
  description = '';

  save() {
    if (!this.title.trim()) return;
    this.api.create({ title: this.title.trim(), description: this.description?.trim() }).subscribe({
      next: () => this.router.navigate(['/tasks']),
      error: (e) => console.error('Error create()', e)
    });
  }
}
