package thrift.module

import com.google.inject.{Provides, Singleton}
import com.twitter.inject.{Injector, TwitterModule}
import core.{CompanyService, CompanyServiceImpl, EmployeeService, EmployeeServiceImpl}
import thrift.{ThriftRouter, ThriftRouterImpl}

object RouterModule extends TwitterModule {

  @Singleton
  @Provides
  def provideEmployeeService : EmployeeService = new EmployeeServiceImpl

  @Singleton
  @Provides
  def provideCompanyService : CompanyService = new CompanyServiceImpl

  @Singleton
  @Provides
  def provideService (injector: Injector): ThriftRouter = {
    new ThriftRouterImpl(provideEmployeeService, provideCompanyService)
  }

}