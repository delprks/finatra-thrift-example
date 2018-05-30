package domain

case class Employee(key : Option[Long], firstName : String, lastName : String, company : Company)

case class Company(key : Option[Long], companyName : String)
