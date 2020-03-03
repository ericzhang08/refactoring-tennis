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
        if (m_score1 == m_score2) {
            return getScoreWhenScoresEqual();
        }
        if (m_score1 >= 4 || m_score2 >= 4) {
            String score1;

            if (getMinusResult() == 1) score1 = "Advantage player1";
            else if (getMinusResult() == -1) score1 = "Advantage player2";
            else if (getMinusResult() >= 2) score1 = "Win for player1";
            else score1 = "Win for player2";
            return score1;
        }
        return transferScoreToString(m_score1) + "-" + transferScoreToString(m_score2);

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

    private String getScoreWhenScoresEqual() {
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