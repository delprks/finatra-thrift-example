package core

import com.twitter.util.{Future => TwitterFuture}
import domain.{Company, Employee}

trait EmployeeService {
  def all: TwitterFuture[ Seq[ Employee ] ]

  def find (key: Long): TwitterFuture[ Option[ Employee ] ]
}

class EmployeeServiceImpl extends EmployeeService {
  val employees = Seq(
    Employee(Some(123), "John", "Doe", Company(Some(1), "Google")),
    Employee(Some(124), "Jane", "Doe", Company(Some(2), "Apple"))
  )

  override def all: TwitterFuture[ Seq[ Employee ] ] = {
    TwitterFuture {
      employees
    }
  }

  override def find (key: Long): TwitterFuture[ Option[ Employee ] ] = {
    TwitterFuture {
      employees.find(_.key == key)
    }
  }
}
