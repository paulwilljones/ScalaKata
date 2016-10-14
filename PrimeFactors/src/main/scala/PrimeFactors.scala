import scala.annotation.tailrec

/**
  * Created by pauljones on 14/10/2016.
  */
object PrimeFactors {

  def result(x: Int): List[Int] = {
    @tailrec
    def calcPrimeFactors(x: Int, a: Int = 2, list: List[Int] = Nil): List[Int] = a*a > x match {
      case false if x % a == 0 => calcPrimeFactors(x / a, a, (a :: list.reverse).reverse)
      case false => calcPrimeFactors(x, a + 1, list)
      case true => if (x == 1) list else (x :: list.reverse).reverse
    }
    calcPrimeFactors(x)
  }
}
