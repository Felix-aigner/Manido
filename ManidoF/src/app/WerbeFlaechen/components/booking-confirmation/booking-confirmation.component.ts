import { Component, OnInit } from '@angular/core';
import {MatDialogRef} from "@angular/material/dialog";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-booking-confirmation',
  templateUrl: './booking-confirmation.component.html',
  styleUrls: ['./booking-confirmation.component.css']
})
export class BookingConfirmationComponent implements OnInit {

  bookingForm = this.fb.group({
    from: this.fb.control('', Validators.required),
    to: this.fb.control('', Validators.required)
  })

  constructor(
    public dialogRef: MatDialogRef<BookingConfirmationComponent>,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
  }

  confirm() {
    this.dialogRef.close({book: true, from: this.bookingForm.value.from, to: this.bookingForm.value.to})
  }

  cancel() {
    this.dialogRef.close({book: false})
  }
}
