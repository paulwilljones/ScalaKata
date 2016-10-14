object BerlinClock {

  def convertToBerlinTime(time: String) = {
    val parts = time.split(":").map(_.toInt)
    Array(
      seconds(parts(2)),
      topHours(parts(0)),
      bottomHours(parts(0)),
      topMinutes(parts(1)),
      bottomMinutes(parts(1))
    )
  }

  def seconds(seconds: Int): String = seconds % 2 match {
      case 0 => "Y"
      case _ => "O"
  }

  def topHours(hours: Int): String = {
    def numOfOnLights(hours: Int) = (hours - (hours % 5)) / 5
    "R" * numOfOnLights(hours) + "O" * (4 - numOfOnLights(hours))
  }

  def bottomHours(hours: Int): String = {
    def numOfOnLights(hours: Int) = hours % 5
    "R" * numOfOnLights(hours) + "O" * (4 - numOfOnLights(hours))
  }

  def topMinutes(minutes: Int): String = {
    def numOfOnLights(minutes: Int) = (minutes - (minutes % 5)) / 5
    ("Y" * numOfOnLights(minutes) + "O" * (11 - numOfOnLights(minutes))).replaceAll("YYY", "YYR")
  }

  def bottomMinutes(minutes: Int): String = {
    def numOfOnLights(minutes: Int) = minutes % 5
    "Y" * numOfOnLights(minutes) + "O" * (4 - numOfOnLights(minutes))
  }
}