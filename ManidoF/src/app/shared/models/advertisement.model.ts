import {UserDTO} from "./user.model";

export interface Advertisement {
  id?: Number | null,
  holder: UserDTO,
  // rental object
  topics: String,
  description: String,
  country: String,
  city: String,
  postalCode: String,
  addressLine: String,
  timelyRestricted: Boolean,
  startOfRental: String,
  endOfRental?: String,
  typeOfRental: RentalType,
  changeWhileActive: Boolean,
  pricePerMonth: Number,
  additionalConditions: String
}


enum RentalType {
  ANSTRICH,
  BEKLEBUNG,
  HALTERUNG,
  OHNEHALTERUNG
}
