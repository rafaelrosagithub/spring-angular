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
  loginError: boolean;
  signingUp: boolean;
  successMessage: string;

  constructor(
    private router: Router,
    private authService: AuthService) { }

  onSubmit() {
    this.router.navigate(['/home']);
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
        this.loginError = false;
      }, error => {
        this.loginError = true;
        this.successMessage = null;
      });
  }

}
