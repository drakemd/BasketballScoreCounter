package edu.upi.cs.drake.basketballscorecounter;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;
import edu.upi.cs.drake.basketballscorecounter.util.CustomMutableLiveData;
import edu.upi.cs.drake.basketballscorecounter.view.ScoreBoardActiviytViewModel;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScoreBoardUnitTest {

    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    ScoreBoard scoreBoard;
    CustomMutableLiveData<ScoreBoard> liveData;

    //class that is being tested
    ScoreBoardActiviytViewModel viewModelToBeTested;

    @Before
    public void setUpScoreBoardViewModel(){
        //this function will be called before all tests are run

        // call this function to init all objects annotated with @mock not needed in this case
        //MockitoAnnotations.initMocks(this);

        scoreBoard = new ScoreBoard();
        liveData = new CustomMutableLiveData<>();

        //we create an instance of the class to be tested by passing the object
        viewModelToBeTested = new ScoreBoardActiviytViewModel(scoreBoard);
    }

    @Test
    public void const_isCorrect() throws Exception {
        assertEquals(0, scoreBoard.getScoreTeamA());
        assertEquals(0, scoreBoard.getScoreTeamB());
    }

    @Test
    public void getData_isCorrect(){
        liveData.setValue(scoreBoard);
        assertEquals(liveData.getValue(),viewModelToBeTested.getData().getValue());
    }

    @Test
    public void addOneForTeamA_isCorrect() {
        viewModelToBeTested.addOneForTeamA();
        assertEquals(1, scoreBoard.getScoreTeamA());
        assertEquals(1, viewModelToBeTested.getData().getValue().getScoreTeamA());
    }

    @Test
    public void addTwoForTeamA_isCorrect() {
        viewModelToBeTested.addTwoForTeamA();
        assertEquals(2, scoreBoard.getScoreTeamA());
        assertEquals(2, viewModelToBeTested.getData().getValue().getScoreTeamA());
    }

    @Test
    public void addThreeForTeamA_isCorrect() {
        viewModelToBeTested.addThreeForTeamA();
        assertEquals(3, scoreBoard.getScoreTeamA());
        assertEquals(3, viewModelToBeTested.getData().getValue().getScoreTeamA());
    }

    @Test
    public void addOneForTeamB_isCorrect() {
        viewModelToBeTested.addOneForTeamB();
        assertEquals(1, scoreBoard.getScoreTeamB());
        assertEquals(1, viewModelToBeTested.getData().getValue().getScoreTeamB());
    }

    @Test
    public void addTwoForTeamB_isCorrect() {
        viewModelToBeTested.addTwoForTeamB();
        assertEquals(2, scoreBoard.getScoreTeamB());
        assertEquals(2, viewModelToBeTested.getData().getValue().getScoreTeamB());
    }

    @Test
    public void addThreeForTeamB_isCorrect() {
        viewModelToBeTested.addThreeForTeamB();
        assertEquals(3, scoreBoard.getScoreTeamB());
        assertEquals(3, viewModelToBeTested.getData().getValue().getScoreTeamB());
    }

    @Test
    public void resetScore(){
        viewModelToBeTested.addThreeForTeamB();
        viewModelToBeTested.resetScore();
        assertEquals(0, scoreBoard.getScoreTeamB());
        assertEquals(0, viewModelToBeTested.getData().getValue().getScoreTeamB());
    }

    @Test
    public void setNameTeamA_provideValid_isCorrect(){
        String name = "Lakers";
        viewModelToBeTested.setNameTeamA(name);
        assertEquals(name,scoreBoard.getNameTeamA());
        assertEquals(name,viewModelToBeTested.getData().getValue().getNameTeamA());
    }

    @Test
    public void setNameTeamB(){
        String name = "Rocket";
        viewModelToBeTested.setNameTeamB(name);
        assertEquals(name,scoreBoard.getNameTeamB());
        assertEquals(name,viewModelToBeTested.getData().getValue().getNameTeamB());
    }
}