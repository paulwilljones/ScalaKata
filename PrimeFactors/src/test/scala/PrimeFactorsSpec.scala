import org.scalatest.{FunSpec, Matchers}

class PrimeFactorsTest extends FunSpec with Matchers {

  describe("Prime Factors") {

    it("must be List() for 1") {
      PrimeFactors.result(1) should equal(List[Int]())
    }

    it("must be List(2) for 2") {
      PrimeFactors.result(2) should equal(List(2))
    }

    it("must be List(3) for 3") {
      PrimeFactors.result(3) should equal(List(3))
    }

    it("must be List(2, 2) for 4") {
      PrimeFactors.result(4) should equal(List(2, 2))
    }

    it("must be List(5) for 5") {
      PrimeFactors.result(5) should equal(List(5))
    }

    it("must be List(2, 3) for 6") {
      PrimeFactors.result(6) should equal(List(2, 3))
    }

    it("must be List(7) for 7") {
      PrimeFactors.result(7) should equal(List(7))
    }

    it("must be List(2, 2, 2) for 8") {
      PrimeFactors.result(8) should equal(List(2, 2, 2))
    }

    it("must be List(3, 3) for 9") {
      PrimeFactors.result(9) should equal(List(3, 3))
    }

    it("must be List(3, 23) for 69") {
      PrimeFactors.result(69) should equal(List(3, 23))
    }

    it("must be List(2, 3, 29) for 174") {
      PrimeFactors.result(174) should equal(List(2, 3, 29))
    }
  }

}