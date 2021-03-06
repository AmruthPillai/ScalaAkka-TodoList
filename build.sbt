name := "ScalaAkka-TodoList"

version := "0.1"

scalaVersion := "2.12.8"

val akkaVersion = "2.5.18"
val akkaHttpVersion = "10.1.5"
val circeVersion = "0.10.0"
val akkaHttpCirceVersion = "1.22.0"
val scalaTestVersion = "3.0.5"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,

  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,

  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test,

  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,

  "de.heikoseeberger" %% "akka-http-circe" % akkaHttpCirceVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test
)
