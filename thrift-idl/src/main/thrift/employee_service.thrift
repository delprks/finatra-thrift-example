namespace java com.sample.employee.thriftjava
#@namespace scala com.sample.employee.thriftscala
namespace rb EmployeeService

# define namespaces for the language you would like to support (in this case Scala, Java and Ruby)
# The order of the struct are important. In this case Company must be declared before Employee.
# further documentation https://twitter.github.io/scrooge/

include "finatra-thrift/finatra_thrift_exceptions.thrift"

struct Company {
    1: optional i64 key ;
    2: required string companyName ;
}

struct Employee {
    1: optional i64 key;
    2: required string firstName ;
    3: required string lastName ;
    4: required Company company ;
}

service EmployeeService {
    list<Employee> allEmployees(
    ) throws (
          1: finatra_thrift_exceptions.ServerError serverError,
          2: finatra_thrift_exceptions.UnknownClientIdError unknownClientIdError
          3: finatra_thrift_exceptions.NoClientIdError noClientIdError
    )

    Employee findEmployee(
        1: required i64 employeeKey;
    ) throws (
         1: finatra_thrift_exceptions.ServerError serverError,
         2: finatra_thrift_exceptions.UnknownClientIdError unknownClientIdError
         3: finatra_thrift_exceptions.NoClientIdError noClientIdError
    )

    list<Company> allCompanies(
    ) throws (
          1: finatra_thrift_exceptions.ServerError serverError,
          2: finatra_thrift_exceptions.UnknownClientIdError unknownClientIdError
          3: finatra_thrift_exceptions.NoClientIdError noClientIdError
    )

    Company findCompany(
        1: required i64 key;
    ) throws (
          1: finatra_thrift_exceptions.ServerError serverError,
          2: finatra_thrift_exceptions.UnknownClientIdError unknownClientIdError
          3: finatra_thrift_exceptions.NoClientIdError noClientIdError
    )
}