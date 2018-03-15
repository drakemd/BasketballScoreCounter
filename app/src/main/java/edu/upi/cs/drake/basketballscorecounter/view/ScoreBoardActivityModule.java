package edu.upi.cs.drake.basketballscorecounter.view;

import dagger.Module;
import dagger.Provides;
import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;

/**
 * Created by drake on 3/15/2018.
 */

@Module
public class ScoreBoardActivityModule {

    @Provides
    ScoreBoardActivityViewModelFactory provideScoreBoardActivityViewModelFactory(ScoreBoard scoreBoard){
        return new ScoreBoardActivityViewModelFactory(scoreBoard);
    }
}
