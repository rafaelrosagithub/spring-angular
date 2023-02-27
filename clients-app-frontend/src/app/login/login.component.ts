import { Component } from '@angular/core';
import { Route, Router } from '@angular/router';

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

  constructor(
    private router: Router) { }

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

}
