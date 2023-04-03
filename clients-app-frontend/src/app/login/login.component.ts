import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { User } from './user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  username: string;
  password: string;
  signingUp: boolean;
  successMessage: string;
  errors: string[];

  constructor(
    private router: Router,
    private authService: AuthService) { }

  onSubmit() {
    this.authService
      .tryLogin(this.username, this.password)
      .subscribe(response => {
        console.log("ok")
        const accessToken = JSON.stringify(response);
        localStorage.clear();
        localStorage.setItem("access_token", accessToken)
        this.router.navigate(['/home']);
      }, errorResponse => {
        this.errors = ['Incorrect username or password.']
      })
  }

  prepareToRegister(event) {
    event.preventDefault();
    this.signingUp = true;
  }

  unsubscribe() {
    console.log("unsubscribe()")
    this.signingUp = false;
  }

  registerUser() {
    console.log("register()")
    const user: User = new User();
    user.username = this.username;
    user.password = this.password;
    this.authService
      .save(user)
      .subscribe(response => {
        this.successMessage = "Successful registration! Log in."
        this.username = '';
        this.password = '';
        this.errors = null;
      }, errorResponse => {
        this.successMessage = null;
        this.errors = errorResponse.error.errors;
      });
  }

}
