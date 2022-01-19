import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {Advertisement} from "../../../shared/models/advertisement.model";
import {UserDTO} from "../../../shared/models/user.model";

@Component({
  selector: 'app-create-werbeflaeche',
  templateUrl: './create-werbeflaeche.component.html',
  styleUrls: ['./create-werbeflaeche.component.css']
})
export class CreateWerbeflaecheComponent implements OnInit {

  werbeflaecheForm = this.fb.group({
    topics: this.fb.control(''),
    description: this.fb.control(''),
    country: this.fb.control(''),
    city: this.fb.control(''),
    postalCode: this.fb.control(''),
    addressLine: this.fb.control(''),
    timelyRestricted: this.fb.control(''),
    startOfRental: this.fb.control(''),
    endOfRental: this.fb.control(''),
    typeOfRental: this.fb.control('Anstrich'),
    changeWhileActive: this.fb.control(''),
    pricePerMonth: this.fb.control(''),
    additionalConditions: this.fb.control(''),
  })


  typeOptions = [
    "Anstrich",
    "Beklebung",
    "Halterung"
  ]

  constructor(
    public dialogRef: MatDialogRef<CreateWerbeflaecheComponent>,
    private fb: FormBuilder,
    @Inject(MAT_DIALOG_DATA) public data: UserDTO
  ) { }

  ngOnInit(): void {
  }

  cancel() {

  }

  submit() {
    const advert: Advertisement = {
      id: null,
      holder: this.data,
      // rental object
      topics: this.werbeflaecheForm.value.topics,
      description: this.werbeflaecheForm.value.description,
      country: this.werbeflaecheForm.value.country,
      city: this.werbeflaecheForm.value.city,
      postalCode: this.werbeflaecheForm.value.postalCode,
      addressLine: this.werbeflaecheForm.value.addressLine,
      timelyRestricted: this.werbeflaecheForm.value.timelyRestricted,
      startOfRental: this.werbeflaecheForm.value.startOfRental,
      endOfRental: (this.werbeflaecheForm.value.timelyRestricted)? this.werbeflaecheForm.value.endOfRental : undefined,
      typeOfRental: this.werbeflaecheForm.value.typeOfRental,
      changeWhileActive: this.werbeflaecheForm.value.changeWhileActive,
      pricePerMonth: this.werbeflaecheForm.value.pricePerMonth,
      additionalConditions: this.werbeflaecheForm.value.additionalConditions
    }
    this.dialogRef.close(advert)
  }
}
