import com.sample.employee.thriftscala.EmployeeService
import com.twitter.finagle.Thrift
import com.twitter.finagle.thrift.ClientId
import com.twitter.util.{Await, Future}
import org.specs2.matcher.ShouldMatchers
import org.specs2.mutable.Specification

class ThriftClientSampleSpec extends Specification with ShouldMatchers {

  private val clientId = ClientId.apply("clientId")
  val employeeService: EmployeeService[Future] = Thrift.client
    .withClientId(clientId)
    .newIface[EmployeeService[Future]]("localhost:9999")

  "The thrift server" should {
    "retrieve all employees" in {
      val employeesFuture = employeeService.allEmployees()
      val employees = Await.result(employeesFuture)

      println(employees)
      employees.size must beGreaterThan(0)
    }

    "retrieve all companies" in {
      val companiesFuture = employeeService.allCompanies()
      val companies = Await.result(companiesFuture)

      companies.size must beGreaterThan(0)
    }

  }
}
