package core

import com.twitter.util.{Future => TwitterFuture}
import domain.Company

trait CompanyService {
  def all: TwitterFuture[ Seq[ Company ] ]

  def find (key: Long): TwitterFuture[ Option[ Company ] ]

  def find (companyName: String): TwitterFuture[ Option[ Company ] ]
}

class CompanyServiceImpl extends CompanyService {
  val companies = Seq(
    Company(Some(1), "Google"),
    Company(Some(2), "Apple")
  )

  override def all: TwitterFuture[ Seq[ Company ] ] = {
    TwitterFuture {
      companies
    }
  }

  override def find (key: Long): TwitterFuture[ Option[ Company ] ] = {
    TwitterFuture {
      companies.find(_.key == key)
    }
  }

  override def find (companyName: String): TwitterFuture[ Option[ Company ] ] = {
    TwitterFuture {
      companies.find(_.companyName.contains(companyName))
    }
  }
}
