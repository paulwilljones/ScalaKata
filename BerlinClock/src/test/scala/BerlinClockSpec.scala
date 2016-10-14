import org.scalatest.{FunSpec, Matchers}

class BerlinClockSpec extends FunSpec with Matchers {

  describe("A Yellow lamp") {

    it("should blink on/off every two seconds") {
      BerlinClock.seconds(0) should be("Y")
      BerlinClock.seconds(1) should be("O")
      BerlinClock.seconds(59) should be("O")
    }
  }

  describe("Top hours") {

    it("should have 4 lamps") {
      BerlinClock.topHours(7).length should be(4)
    }

    it("should light a red lamp for every 5 hours") {
      BerlinClock.topHours(0) should be("OOOO")
      BerlinClock.topHours(13) should be("RROO")
      BerlinClock.topHours(23) should be("RRRR")
      BerlinClock.topHours(24) should be("RRRR")
    }
  }

  describe("Bottom hours") {

    it("should have 4 lamps") {
      BerlinClock.bottomHours(5).length should be(4)
    }

    it("should light a red lamp for every hour left from top hours") {
      BerlinClock.bottomHours(0) should be("OOOO")
      BerlinClock.bottomHours(13) should be("RRRO")
      BerlinClock.bottomHours(23) should be("RRRO")
      BerlinClock.bottomHours(24) should be("RRRR")
    }
  }

  describe("Top minutes") {
    it("should have 11 lamps") {
      BerlinClock.topMinutes(34).length should be(11)
    }

    it("should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter") {
      val minutes32 = BerlinClock.topMinutes(32)
      minutes32(2) should be('R')
      minutes32(5) should be('R')
      minutes32(8) should be('O')
    }

    it("should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter") {
      BerlinClock.topMinutes(0) should be("OOOOOOOOOOO")
      BerlinClock.topMinutes(17) should be("YYROOOOOOOO")
      BerlinClock.topMinutes(59) should be("YYRYYRYYRYY")
    }
  }

  describe("Bottom minutes") {
    it("should have 4 lamps") {
      BerlinClock.bottomMinutes(0).length should be(4)
    }

    it("should light a yellow lamp for every minute left from top minutes") {
      BerlinClock.bottomMinutes(0) should be("OOOO")
      BerlinClock.bottomMinutes(17) should be("YYOO")
      BerlinClock.bottomMinutes(59) should be("YYYY")
    }
  }

  describe("Berlin Clock") {
    it("should result in array with 5 elements") {
      BerlinClock.convertToBerlinTime("13:17:01").size should be(5)
    }

    it("should result in correct seconds, hours and minutes") {
      val berlinTime = BerlinClock.convertToBerlinTime("16:37:16")
      println(berlinTime)
      val expected = Array("Y", "RRRO", "ROOO", "YYRYYRYOOOO", "YYOO")
      berlinTime should equal(expected)
    }
  }

}