import sbt._
import sbt.Keys._


object ScalaBuild extends Build {

  object Version {
    val HadoopCore    = "2.3.0-mr1-cdh5.0.0"
    val HadoopCommon  = "2.4.0"
    val ScalaTest     = "2.0"
    val Scala         = "2.10.4"
  }

  val buildSettings = Defaults.defaultSettings ++ Seq(
    name          := "scala-demo",
    version       := "1.0.0",
    scalaVersion  := "2.10.4"
  )

  val scalaResolvers = Seq(
    "Typesafe"  at "http://repo.typesafe.com/typesafe/releases/",
    "Maven"     at "http://mvnrepository.com/artifact",
    "Cloudera"  at "https://repository.cloudera.com/artifactory/cloudera-repos/"
  )

  val dependencies = Seq(
    "org.scala-lang"    % "scala-compiler"  % Version.Scala,
    "org.apache.hadoop" % "hadoop-core"     % Version.HadoopCore,
    "org.apache.hadoop" % "hadoop-common"   % Version.HadoopCommon,
    "org.scalatest"     % "scalatest_2.10"  % Version.ScalaTest     % "test"
  )

  lazy val scala = Project(
    id = "scala-demo",
    base = file("."),
    settings = buildSettings ++ Seq(
      resolvers ++= scalaResolvers,
      libraryDependencies ++= dependencies,
      retrieveManaged := true
    )
  )
}