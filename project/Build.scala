import sbt._
import Keys._

object ThriftBuild extends Build {
  import BuildSettings._
  import Dependencies._

  lazy val parent = Project(id = "fintatra-thrift-example",
    base = file("."))
    .aggregate (thriftIdl, thriftCore)
    .settings(baseSettings: _*)

  lazy val thriftIdl = Project(id = "thrift-idl", base = file("thrift-idl"))
    .settings(thriftIdlSettings: _*)
    .settings(libraryDependencies ++= baseDependencies ++ finatraDependencies ++ testDependencies)

  lazy val thriftCore = Project(id = "thrift-core", base = file("thrift-core"))
    .settings(thriftCoreSettings: _*)
    .settings(libraryDependencies ++= baseDependencies ++ finatraDependencies
      ++ thriftClientDependency
    )
    .dependsOn(thriftIdl)
}