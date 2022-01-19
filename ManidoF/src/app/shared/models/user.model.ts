export interface UserDTO{
  id?: number,
  role: String,
  username: String,
  password?: String,
  email: String,
  // address
  country?: String,
  city?: String,
  postalCode?: String,
  addressLine?: String,
  token?: String
}
