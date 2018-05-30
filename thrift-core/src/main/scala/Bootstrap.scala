
import com.twitter.finatra.thrift.ThriftServer
import com.twitter.finatra.thrift.filters._
import com.twitter.finatra.thrift.modules.ClientIdWhitelistModule
import com.twitter.finatra.thrift.routing.ThriftRouter
import thrift.ThriftController
import thrift.filter.ExceptionTranslationFilter
import thrift.module.RouterModule

object Bootstrap extends BootstrapThriftServer

class BootstrapThriftServer extends ThriftServer {

  override protected def disableAdminHttpServer: Boolean = false
  override protected def defaultFinatraThriftPort: String = ":9999"

  override def modules = Seq(ClientIdWhitelistModule, RouterModule)

  override protected def configureThrift(router: ThriftRouter): Unit = {
    router
      .filter[LoggingMDCFilter]
      .filter[TraceIdMDCFilter]
      .filter[ThriftMDCFilter]
      .filter[AccessLoggingFilter]
      .filter[ExceptionTranslationFilter]
      .filter[ClientIdWhitelistFilter]
      .add[ThriftController] // only one controller can be added to the thrift server. Limitation
    // of the finatra framework
  }
}