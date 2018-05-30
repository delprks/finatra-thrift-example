package thrift

import java.util.concurrent.Executors

import com.sample.employee.thriftscala.{Company, Employee}
import com.google.inject.Inject
import com.twitter.util.{FuturePool, Future => TwitterFuture}
import core.{CompanyService, EmployeeService}

trait ThriftRouter {
  def allEmployees: TwitterFuture[ Seq[ Employee ] ]

  def findEmployee (key: Long): TwitterFuture[ Employee ]

  def allCompanies: TwitterFuture[ Seq[ Company ] ]

  def findCompany (key: Long): TwitterFuture[ Company ]
}

class ThriftRouterImpl @Inject() (employeeService: EmployeeService,
                                  companyService: CompanyService) extends ThriftRouter {

  val futurePool = FuturePool(Executors.newCachedThreadPool())

  override def allEmployees: TwitterFuture[ Seq[ Employee ] ] = {
    futurePool(employeeService.all).flatten map { emps =>
      emps.map(emp => Employee(emp.key, emp.firstName, emp.lastName, Company(emp.company.key, emp
        .company.companyName)))
    }
  }

  override def findEmployee (key: Long): TwitterFuture[ Employee ] = {
    futurePool(employeeService.find(key)).flatten map {
      case Some(emp) => Employee(emp.key, emp.firstName, emp.lastName, Company(emp.company.key, emp
        .company.companyName))
    }
  }

  override def allCompanies: TwitterFuture[ Seq[ Company ] ] = {
    futurePool(companyService.all).flatten map { comps =>
      comps.map(comp => Company(comp.key, comp.companyName))
    }
  }

  override def findCompany (key: Long): TwitterFuture[ Company ] = {
    futurePool(companyService.find(key)).flatten map {
      case Some(comp) => Company(comp.key, comp.companyName)
    }
  }
}
