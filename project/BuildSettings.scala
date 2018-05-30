import sbt._
import Keys._

object BuildSettings {
  import Dependencies._

  lazy val baseSettings = Seq(
    version := "0.1.0-SNAPSHOT",
    organization := "be.sdtechnologies",
    startYear := Some(2016),
    licenses := Seq("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt")),
    scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8"),
    scalaVersion := "2.11.8",
    resolvers ++= resolutions
  )

  lazy val thriftIdlSettings = baseSettings ++ Seq(

  )

  lazy val thriftCoreSettings = baseSettings ++ Seq(

  )
}