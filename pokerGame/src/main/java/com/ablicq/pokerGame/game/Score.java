package com.ablicq.pokerGame.game;


public class Score implements Comparable<Score> {
    private int eval;
    private int absoluteHeight;
    private int auxHeight=0;

    public Score(int eval, int absoluteHeight) {
        this.eval = eval;
        this.absoluteHeight = absoluteHeight;
    }

    public Score(int eval, int absoluteHeight, int auxHeight) {
        this.eval = eval;
        this.absoluteHeight = absoluteHeight;
        this.auxHeight = auxHeight;
    }

    public int getEval() {
        return eval;
    }

    public int getAbsoluteHeight() {
        return absoluteHeight;
    }

    public int getAuxHeight() {
        return auxHeight;
    }

    @Override
    public int compareTo(Score other) {
        int tmp = this.eval - other.eval;
        if(tmp == 0) {
            tmp = this.absoluteHeight - other.absoluteHeight;
            if(tmp == 0) {
                tmp = this.auxHeight - other.auxHeight;
            }
        }
        return tmp;
    }
}
