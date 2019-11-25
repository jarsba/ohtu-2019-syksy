package ohtu;

public class TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScoreForEvenPlay() {
        if(m_score1 > 3) {
            return "Deuce";
        } else {
            return getScoreForPoint(m_score1) + "-All";
        }
    }

    public String getScoreForPoint(int tempScore) {
        String score = "";
        switch (tempScore) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return score;
    }

    public String getScoreForOverOrEqualsFour() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (Math.abs(minusResult) == 1) {
            return minusResult == 1 ? "Advantage player1" : "Advantage player2";
        } else {
            return minusResult >= 2 ? "Win for player1" : "Win for player2";
        }
    }

    public String getScore() {
        if (m_score1 == m_score2) {
            return getScoreForEvenPlay();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return getScoreForOverOrEqualsFour();
        } else {
            return getScoreForPoint(m_score1) + "-" + getScoreForPoint(m_score2);
        }
    }
}