package edu.upi.cs.drake.basketballscorecounter.view;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import javax.inject.Inject;

import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;

/**
 * Created by drake on 3/15/2018.
 */

public class ScoreBoardActivityViewModelFactory implements ViewModelProvider.Factory {

    private ScoreBoard scoreBoard;

    @Inject
    public ScoreBoardActivityViewModelFactory(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ScoreBoardActiviytViewModel.class)){
            return (T) new ScoreBoardActiviytViewModel(scoreBoard);
        }
        throw new IllegalArgumentException("View Model Type not known");
    }
}
