package edu.upi.cs.drake.basketballscorecounter.view;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;
import edu.upi.cs.drake.basketballscorecounter.util.CustomMutableLiveData;

/**
 * Created by drake on 3/15/2018.
 * view model for scoreBoardActivity
 */

public class ScoreBoardActiviytViewModel extends ViewModel{

    private final CustomMutableLiveData<ScoreBoard> data = new CustomMutableLiveData<>();
    private ScoreBoard scoreBoard;

    @Inject
    public ScoreBoardActiviytViewModel(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
        data.setValue(scoreBoard);
    }

    public CustomMutableLiveData<ScoreBoard> getData(){
        return data;
    }

    //increase team A score by 1
    public void addOneForTeamA() {
        this.scoreBoard.setScoreTeamA(this.scoreBoard.getScoreTeamA() + 1);
    }

    //increase team A score by 2
    public void addTwoForTeamA() {
        this.scoreBoard.setScoreTeamA(this.scoreBoard.getScoreTeamA() + 2);
    }

    //increase team A score by 3
    public void addThreeForTeamA() {
        this.scoreBoard.setScoreTeamA(this.scoreBoard.getScoreTeamA() + 3);
    }

    //increase team B score by 1
    public void addOneForTeamB() {
        this.scoreBoard.setScoreTeamB(this.scoreBoard.getScoreTeamB() + 1);
    }

    //increase team B score by 2
    public void addTwoForTeamB() {
        this.scoreBoard.setScoreTeamB(this.scoreBoard.getScoreTeamB() + 2);
    }

    //increase team B score by 3
    public void addThreeForTeamB() {
        this.scoreBoard.setScoreTeamB(this.scoreBoard.getScoreTeamB() + 3);
    }

    //reset score to 0
    public void resetScore(){
        this.scoreBoard.setScoreTeamA(0);
        this.scoreBoard.setScoreTeamB(0);
    }

    //change team A's name
    public void setNameTeamA(String name){
        this.scoreBoard.setNameTeamA(name);
    }

    //change team B's name
    public void setNameTeamB(String name){
        this.scoreBoard.setNameTeamB(name);
    }
}
