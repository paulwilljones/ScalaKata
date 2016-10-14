
class Player(val name: String) {

  var score = 0
  def winBall() = score += 1
  def compare(that: Player) = this.score - that.score
}

class TennisGame(player1: Player, player2: Player) {

  def scores(score: Int) = score match {
    case 0 => "love"
    case 1 => "fifteen"
    case 2 => "thirty"
    case 3 => "forty"
  }

  def leadPlayer = if (player1.score > player2.score) player1 else player2

  def score = {
    def withinTieBreak(score1: Int, score2: Int) = { score1 >= 3 && score2 >= 3 }
    withinTieBreak(score1 = player1.score, score2 = player2.score) match {
      case true if Math.abs(player2.score - player1.score) >= 2 => "%s won" format leadPlayer.name
      case true if player1.score == player2.score => "deuce"
      case true => "advantage %s".format(leadPlayer.name)
      case false => "%s, %s".format(scores(player1.score), scores(player2.score))

    }
  }
}

object Player {
  def apply(name: String) = { new Player(name)}
}