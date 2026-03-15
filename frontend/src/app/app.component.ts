import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  users:User[] = [];
  name='';
  email='';

  constructor(private http:HttpClient){
    this.loadUsers();
  }

  loadUsers(){
    this.http.get<User[]>('https://mass-api-468386309267.asia-south1.run.app/api/users')
      .subscribe(data => this.users = data);
  }

  save(){
    //this.http.post('http://localhost:8080/api/users',
    this.http.post('https://mass-api-468386309267.asia-south1.run.app/api/users',
      {name:this.name, email:this.email})
      .subscribe(() => {
        this.name='';
        this.email='';
        this.loadUsers();
      });
  }

  delete(id: string){
    this.http.delete('https://mass-api-468386309267.asia-south1.run.app/api/users/' + id)
      .subscribe(() => this.loadUsers());
  }
}
