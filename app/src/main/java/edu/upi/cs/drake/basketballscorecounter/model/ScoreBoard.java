package edu.upi.cs.drake.basketballscorecounter.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import edu.upi.cs.drake.basketballscorecounter.BR;


/**
 * Created by drake on 3/15/2018.
 * ScoreBoatd Entity extending baseobservable
 * so view can be notified when there is a changed in it
 */

public class ScoreBoard extends BaseObservable{

    private String nameTeamA = "Team A";
    private String nameTeamB = "Team B";
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    @Bindable
    public String getNameTeamA() {
        return nameTeamA;
    }

    public void setNameTeamA(String nameTeamA) {
        this.nameTeamA = nameTeamA;
        notifyPropertyChanged(BR.nameTeamA);
    }

    @Bindable
    public String getNameTeamB() {
        return nameTeamB;
    }

    public void setNameTeamB(String nameTeamB) {
        this.nameTeamB = nameTeamB;
        notifyPropertyChanged(BR.nameTeamB);
    }

    @Bindable
    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
        notifyPropertyChanged(BR.scoreTeamA);
    }

    @Bindable
    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
        notifyPropertyChanged(BR.scoreTeamB);
    }
}
