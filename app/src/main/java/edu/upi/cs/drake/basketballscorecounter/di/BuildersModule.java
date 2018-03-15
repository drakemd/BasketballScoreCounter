package edu.upi.cs.drake.basketballscorecounter.di;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import edu.upi.cs.drake.basketballscorecounter.view.ScoreBoardActivity;
import edu.upi.cs.drake.basketballscorecounter.view.ScoreBoardActivityModule;

/**
 * Created by drake on 3/15/2018.
 * declare/provide activity dependency
 */

@Module
public abstract class BuildersModule {

    @ContributesAndroidInjector(modules = ScoreBoardActivityModule.class)
    abstract ScoreBoardActivity bindScoreBoardActivity();
}
