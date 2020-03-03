package cn.xpbootcamp.tennis.game1;

import cn.xpbootcamp.tennis.TennisGame;

public class TennisGame1 implements TennisGame {

    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (playerName.equals("player1"))
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        if (isEqualScore()) {
            return displayEqualScore(m_score1);
        }

        if (isAdvantage()) {
            return displayAdvantageScore();

        }

        if (iswin()) {
            return displayWinScore();
        }
        return displayNormalScore();

    }

    private String displayNormalScore() {
        return transferScoreToString(m_score1) + "-" + transferScoreToString(m_score2);
    }

    private String displayWinScore() {
        return getMinusResult() > 0 ? "Win for player1" : "Win for player2";
    }

    private String displayAdvantageScore() {
        return getMinusResult() > 0 ? "Advantage player1" : "Advantage player2";
    }

    private boolean iswin() {
        return (m_score1 >= 4 || m_score2 >= 4) && Math.abs(getMinusResult()) >= 2;
    }

    private boolean isAdvantage() {
        return m_score1 >= 3 && m_score2 >= 3 && Math.abs(getMinusResult()) == 1;
    }

    private boolean isEqualScore() {
        return m_score1 == m_score2;
    }

    private int getMinusResult() {
        return m_score1 - m_score2;
    }

    private String transferScoreToString(int score) {
        String result = "";
        switch (score) {
            case 0:
                result += "Love";
                break;
            case 1:
                result += "Fifteen";
                break;
            case 2:
                result += "Thirty";
                break;
            case 3:
                result += "Forty";
                break;
        }
        return result;
    }

    private String displayEqualScore(int m_score1) {
        String score;
        switch (m_score1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
        return score;
    }


}