package edu.upi.cs.drake.basketballscorecounter.view;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import edu.upi.cs.drake.basketballscorecounter.R;
import edu.upi.cs.drake.basketballscorecounter.model.ScoreBoard;

public class ScoreBoardActivity extends AppCompatActivity {

    @Inject
    ScoreBoardActivityViewModelFactory viewModelFactory;

    private ScoreBoardActiviytViewModel viewModel;

    private TextView tvNameTeamA, tvNameTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);

        tvNameTeamA = findViewById(R.id.tv_name_team_a);
        tvNameTeamB = findViewById(R.id.tv_name_team_b);

        viewModel = ViewModelProviders.of(this,viewModelFactory)
                .get(ScoreBoardActiviytViewModel.class);

        viewModel.getData().observe(
                this, scoreBoard ->
                        refreshScore(scoreBoard)
        );
    }

    private void refreshScore(ScoreBoard scoreBoard) {
        displayForTeamA(scoreBoard.getNameTeamA(), scoreBoard.getScoreTeamA());
        displayForTeamB(scoreBoard.getNameTeamB(), scoreBoard.getScoreTeamB());
    }

    public void addOneForTeamA(View view) {
        viewModel.addOneForTeamA();
    }

    public void addTwoForTeamA(View view) {
        viewModel.addTwoForTeamA();
    }

    public void addThreeForTeamA(View view) {
        viewModel.addThreeForTeamA();
    }

    public void addOneForTeamB(View view) {
        viewModel.addOneForTeamB();
    }

    public void addTwoForTeamB(View view) {
        viewModel.addTwoForTeamB();
    }

    public void addThreeForTeamB(View view) {
        viewModel.addThreeForTeamB();
    }

    public void resetScore(View view) {
        viewModel.resetScore();
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(String name, int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        tvNameTeamA.setText(name);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(String name, int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        tvNameTeamB.setText(name);
        scoreView.setText(String.valueOf(score));
    }

    public void setNameTeamA(View view) {
        createDialog(0);
    }

    public void setNameTeamB(View view) {
        createDialog(1);
    }

    public void createDialog(int teamIndex){

        LayoutInflater inflater = LayoutInflater.from(this);
        final View dialogView = inflater.inflate(R.layout.dialog_set_name, null);
        final TextView etName = dialogView.findViewById(R.id.ev_team_name);

        Button btnOK = dialogView.findViewById(R.id.btn_ok);
        Button btnCancel = dialogView.findViewById(R.id.btn_cancel);

        Dialog dialog = new Dialog(this);
        dialog.setContentView(dialogView);
        dialog.show();

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.getWindow().setAttributes(layoutParams);

        btnOK.setOnClickListener(view -> {
            if(teamIndex == 0){
                viewModel.setNameTeamA(etName.getText().toString());
            }else{
                viewModel.setNameTeamB(etName.getText().toString());
            }
            dialog.dismiss();
        });

        btnCancel.setOnClickListener(view -> {
          dialog.dismiss();
        });
    }
}
