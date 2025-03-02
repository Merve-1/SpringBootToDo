import { Component, OnInit } from '@angular/core';
import { TodoService } from '../todo.service';
import { Todo } from '../todo.models';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css',
})


export class TodoComponent implements OnInit {
  newTask: Todo = {
    title: '',
    date: new Date(),
    status: '',
  };

  todos: Todo[] = [];
  isComponentActive = true; // 🔹 Used to reload the component

  constructor(private toDoService: TodoService) {}

  ngOnInit(): void {
    this.loadTodos();
  }

  loadTodos() {
    this.toDoService.getTodo().subscribe({
      next: (data) => {
        this.todos = data.map(todo => ({
          ...todo,
          date: new Date(todo.date),
        }));
      },
      error: (error) => {
        console.error('Error fetching Todos: ', error);
      },
    });
  }

  createToDo() {
    if (!this.newTask.title.trim() || !this.newTask.status.trim()) {
      console.error("Task title and status cannot be empty.");
      return;
    }

    const taskToCreate = {
      id: this.newTask.id,  // Ensure ID is captured
      title: this.newTask.title,
      date: new Date(),
      status: this.newTask.status,
    };

    this.toDoService.createTodo(taskToCreate).subscribe({
      next: (createdToDo) => {
        console.log('Created Task:', createdToDo);
        createdToDo.date = new Date(createdToDo.date);

       
        this.resetForm();
        this.loadTodos();
      },
      error: (err) => {
        console.error('Error creating Todo:', err);
      },
    });
  }

  editTask(task: Todo) {
    // Populate form fields with selected task data
    this.newTask = { ...task };
  }
  
  deleteTask(id?: number) {
    if (!id) {
      console.error('Invalid Task ID for deletion');
      return;
    }
  
    if (confirm('Are you sure you want to delete this task?')) {
      this.toDoService.deleteTodo(id).subscribe({
        next: () => {
          console.log(`Task ${id} deleted.`);
          this.todos = this.todos.filter(todo => todo.id !== id); // Remove from UI
        },
        error: (err) => {
          console.error('Error deleting Todo:', err);
        },
      });
    }
  }
  
  

  resetForm() {
    this.newTask = { title: '', date: new Date(), status: '' };
  }
}
