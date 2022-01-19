import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from '@angular/material/dialog';
import {FormBuilder, Validators} from "@angular/forms";
import {LoginCredential} from "../../models/loginCredential.model";
import {UserDTO} from "../../models/user.model";


@Component({
  selector: 'app-login-dialog',
  templateUrl: './login-dialog.component.html',
  styleUrls: ['./login-dialog.component.scss']
})
export class LoginDialogComponent implements OnInit {

  userForm = this.fb.group({
    username: this.fb.control('', Validators.required),
    password: this.fb.control('', Validators.required),
    email: this.fb.control(''),
    country: this.fb.control(''),
    city: this.fb.control(''),
    postalCode: this.fb.control(''),
    addressLine: this.fb.control(''),
    role: this.fb.control('Unternehmen')
  })

  roleOptions = [
    'Unternehmen',
    'Anbieter'
  ]

  constructor(
    public dialogRef: MatDialogRef<LoginDialogComponent>,
    private fb: FormBuilder
  ) {
  }


  ngOnInit(): void {
  }

  login() {
    const login: LoginCredential = {
      username: this.userForm.value.username,
      password: this.userForm.value.password
    }
    this.dialogRef.close(login)
  }

  allTouched() {
    return this.userForm.controls["username"].dirty &&
      this.userForm.controls["password"].dirty &&
      this.userForm.controls["email"].dirty &&
      this.userForm.controls["country"].dirty &&
      this.userForm.controls["city"].dirty &&
      this.userForm.controls["postalCode"].dirty &&
      this.userForm.controls["addressLine"].dirty
  }

  register() {
    const user: UserDTO = {
      username: this.userForm.value.username,
      password: this.userForm.value.password,
      email: this.userForm.value.email,
      country: this.userForm.value.country,
      city: this.userForm.value.city,
      postalCode: this.userForm.value.postalCode,
      addressLine: this.userForm.value.addressLine,
      role: this.userForm.value.role

    }
    this.dialogRef.close(user)
  }
}
