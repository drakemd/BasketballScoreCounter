package edu.upi.cs.drake.basketballscorecounter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.upi.cs.drake.basketballscorecounter.view.ScoreBoardActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ScoreBoardActivityInstrumentedTest {

    @Rule
    public ActivityTestRule<ScoreBoardActivity> activityTestRule
            = new ActivityTestRule<>(ScoreBoardActivity.class);

    @Test
    public void clickBtnOneA_scoreAChangedByOne() {
        onView(withId(R.id.btn_one_a))
                .perform(click());
        onView(withId(R.id.team_a_score)).check(matches(withText("1")));
    }

    @Test
    public void clickBtnTwoA_scoreAChangedByTwo() {
        onView(withId(R.id.btn_two_a))
                .perform(click());
        onView(withId(R.id.team_a_score)).check(matches(withText("2")));
    }

    @Test
    public void clickBtnThreeA_scoreAChangedByThree() {
        onView(withId(R.id.btn_three_a))
                .perform(click());
        onView(withId(R.id.team_a_score)).check(matches(withText("3")));
    }

    @Test
    public void clickBtnOneB_scoreBChangedByOne() {
        onView(withId(R.id.btn_one_b))
                .perform(click());
        onView(withId(R.id.team_b_score)).check(matches(withText("1")));
    }

    @Test
    public void clickBtnTwoB_scoreBChangedByTwo() {
        onView(withId(R.id.btn_two_b))
                .perform(click());
        onView(withId(R.id.team_b_score)).check(matches(withText("2")));
    }

    @Test
    public void clickBtnThreeB_scoreBChangedByThree() {
        onView(withId(R.id.btn_three_b))
                .perform(click());
        onView(withId(R.id.team_b_score)).check(matches(withText("3")));
    }

    @Test
    public void clickBtnSimultaneously_scoreBChanged() {
        onView(withId(R.id.btn_three_b))
                .perform(click());
        onView(withId(R.id.btn_one_b))
                .perform(click());
        onView(withId(R.id.btn_two_a))
                .perform(click());
        onView(withId(R.id.btn_three_b))
                .perform(click());
        onView(withId(R.id.btn_two_a))
                .perform(click());
        onView(withId(R.id.btn_three_b))
                .perform(click());
        onView(withId(R.id.btn_three_a))
                .perform(click());

        onView(withId(R.id.team_b_score)).check(matches(withText("10")));
        onView(withId(R.id.team_a_score)).check(matches(withText("7")));
    }

    @Test
    public void clickTvNameA_openDialog() {
        onView(withId(R.id.tv_name_team_a))
                .perform(click());
        onView(withId(R.id.dialog_set_name)).check(matches(isDisplayed()));
    }

    @Test
    public void clickTvNameB_openDialog() {
        onView(withId(R.id.tv_name_team_b))
                .perform(click());
        onView(withId(R.id.dialog_set_name)).check(matches(isDisplayed()));
    }

    @Test
    public void typeNewANameAndClickOk_TvNameAChanged() {
        onView(withId(R.id.tv_name_team_a))
                .perform(click());
        onView(withId(R.id.ev_team_name))
                .perform(typeText("Dallas"));
        onView(withId(R.id.btn_ok))
                .perform(click());
        onView(withId(R.id.tv_name_team_a)).check(matches(withText("Dallas")));
    }

    @Test
    public void typeNewBNameAndClickOk_TvNameBChanged() {
        onView(withId(R.id.tv_name_team_b))
                .perform(click());
        onView(withId(R.id.ev_team_name))
                .perform(typeText("Lakers"));
        onView(withId(R.id.btn_ok))
                .perform(click());
        onView(withId(R.id.tv_name_team_b)).check(matches(withText("Lakers")));
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("edu.upi.cs.drake.basketballscorecounter", appContext.getPackageName());
    }
}
