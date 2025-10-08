import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { TaskService, TaskDto } from '../task.service';

@Component({
  selector: 'app-task-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './task-list.html',
  styleUrl: './task-list.scss'
})
export class TaskList {
  private api = inject(TaskService);
  tasks: TaskDto[] = [];
  newTitle = '';

  ngOnInit() { this.reload(); }

  reload() {
    this.api.list().subscribe({
      next: (list) => this.tasks = list,
      error: (e) => console.error('Error list()', e)
    });
  }

  add() {
    if (!this.newTitle.trim()) return;
    this.api.create({ title: this.newTitle.trim() }).subscribe({
      next: () => { this.newTitle = ''; this.reload(); },
      error: (e) => console.error('Error create()', e)
    });
  }

  toggle(t: TaskDto) {
    this.api.toggle(t.id).subscribe({
      next: () => this.reload(),
      error: (e) => console.error('Error toggle()', e)
    });
  }

  del(t: TaskDto) {
    this.api.remove(t.id).subscribe({
      next: () => this.reload(),
      error: (e) => console.error('Error remove()', e)
    });
  }
}


