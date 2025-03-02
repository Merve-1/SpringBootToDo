import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './todo.models';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) {}

  createTodo(todo: Todo): Observable<Todo> {
    const url = `${this.baseUrl}/saveToDoItem`;
    return this.http.post<Todo>(url, todo);
  }

  getTodo(): Observable<Todo[]> {
    const url = `${this.baseUrl}/viewToDoList`;
    return this.http.get<Todo[]>(url);
  }

  getTodoById(id: number): Observable<Todo> {
    const url = `${this.baseUrl}/getToDoItem/${id}`;
    return this.http.get<Todo>(url);
  }

  updateTodoStatus(id: number, status: string): Observable<Todo> {
    const url = `${this.baseUrl}/updateToDoStatus/${id}`;
    return this.http.put<Todo>(url, { status });
  }

  editTodoValues(todo: Todo): Observable<Todo> {
    const url = `${this.baseUrl}/editToDoItem`;
    return this.http.put<Todo>(url, todo);
  }

  deleteTodo(id: number): Observable<void> {
    const url = `${this.baseUrl}/deleteToDoItem/${id}`;
    return this.http.delete<void>(url);
  }
}
