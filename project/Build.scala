import sbt._
import Keys._

object MultiBuild extends Build {
  lazy val root = Project(id = "ScalaKata",
                          base = file(".")) aggregate(FizzBuzz, BerlinClock, PrimeFactors, TennisGame) dependsOn(FizzBuzz, BerlinClock, PrimeFactors, TennisGame)

  lazy val FizzBuzz = Project(id = "FizzBuzz", base = file("FizzBuzz"))
  lazy val BerlinClock = Project(id = "BerlinClock", base = file("BerlinClock"))
  lazy val PrimeFactors = Project(id = "PrimeFactors", base = file("PrimeFactors"))
  lazy val TennisGame = Project(id = "TennisGame", base = file("TennisGame"))
}
