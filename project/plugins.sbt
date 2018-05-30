addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")
addSbtPlugin("com.typesafe" % "sbt-mima-plugin" % "0.1.7")
addSbtPlugin("org.scoverage" % "sbt-coveralls" % "1.0.0.BETA1")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.0-RC2")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.3")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.6")

resolvers ++= Seq(
  Classpaths.sbtPluginSnapshots,
  Classpaths.sbtPluginReleases,
  Resolver.sonatypeRepo("snapshots"),
  "Twitter Maven" at "https://maven.twttr.com"
)

addSbtPlugin("com.twitter" % "scrooge-sbt-plugin" % "4.15.0")
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.6.8")

