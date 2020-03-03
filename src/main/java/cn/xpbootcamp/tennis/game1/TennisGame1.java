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
        String score = "";
        if (m_score1 == m_score2) {
            return getScoreWhenScoresEqual();
        } else if (m_score1 >= 4 || m_score2 >= 4) {
            return  getScoreWhenOneOfScoreBiggerThan4();
        } else {
            return getNormalScore();
        }
    }

    private String getNormalScore() {
        String score = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                int tempScore1 ;
                tempScore1 = m_score1;
                score += transferScoreToString(tempScore1);
            }
            else {
                score += "-";
                int tempScore;
                tempScore = m_score2;
                score += transferScoreToString(tempScore);
            }
        }
        return score;
    }

    private String transferScoreToString(int tempScore) {
        String result = "";
        switch (tempScore) {
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

    private String getScoreWhenOneOfScoreBiggerThan4() {
        String score;
        int minusResult = m_score1 - m_score2;
        if (minusResult == 1) score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2) score = "Win for player1";
        else score = "Win for player2";
        return score;
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