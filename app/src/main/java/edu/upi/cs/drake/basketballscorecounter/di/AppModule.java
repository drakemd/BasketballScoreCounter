package edu.upi.cs.drake.basketballscorecounter.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import edu.upi.cs.drake.basketballscorecounter.App;
import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;

/**
 * Created by drake on 3/15/2018.
 * declare/provide application-wide dependencies
 */

@Module
public class AppModule {

    @Provides
    Context provideApplicationContext(App app){
        return app.getApplicationContext();
    }

    @Provides
    ScoreBoard provideScoreBoard(){
        return new ScoreBoard();
    }

}
