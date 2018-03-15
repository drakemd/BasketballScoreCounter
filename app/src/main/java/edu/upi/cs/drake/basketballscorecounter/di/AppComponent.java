package edu.upi.cs.drake.basketballscorecounter.di;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import edu.upi.cs.drake.basketballscorecounter.App;

/**
 * Created by drake on 3/15/2018.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, BuildersModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(App app);
        AppComponent build();
    }

    void inject(App app);
}
