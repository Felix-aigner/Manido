import {Component, Input, OnInit} from '@angular/core';
import {Advertisement} from "../../../shared/models/advertisement.model";
import {MatDialog} from "@angular/material/dialog";
import {BookingConfirmationComponent} from "../booking-confirmation/booking-confirmation.component";

@Component({
  selector: 'app-werbeflaeche-card',
  templateUrl: './werbeflaeche-card.component.html',
  styleUrls: ['./werbeflaeche-card.component.css']
})
export class WerbeflaecheCardComponent implements OnInit {
  @Input() ad: Advertisement | undefined
  @Input() bookingAllowed: boolean = false

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }

  openDetails() {
    if(this.ad) {
      console.log("opening details")
    }
  }

  bookAd() {
    const dialogRef = this.dialog.open(BookingConfirmationComponent, {
      width: "250px"
    })
  }
}
