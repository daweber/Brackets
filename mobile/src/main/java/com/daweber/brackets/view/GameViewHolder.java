package com.daweber.brackets.view;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.daweber.brackets.R;

/**
 * Game ViewHolder class
 */
public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "b64.GameViewHolder";

    protected ResizeTextView viewTeamOne, viewTeamTwo, viewGameDetails;
    protected TextView viewBracketRegion;

    protected int gID;

    public GameViewHolder(View v) {
        super(v);
        viewTeamOne = (ResizeTextView) v.findViewById(R.id.team_one);
        viewTeamOne.setOnClickListener(this);
        viewTeamTwo = (ResizeTextView) v.findViewById(R.id.team_two);
        viewTeamTwo.setOnClickListener(this);
        viewGameDetails = (ResizeTextView) v.findViewById(R.id.game_details);
        viewBracketRegion = (TextView) v.findViewById(R.id.bracket_region);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.team_one:
                //TODO: update/create pick record, update game record.
                Log.d(TAG, viewTeamOne.getText() + " Picked in game: " + gID);
                break;
            case R.id.team_two:
                Log.d(TAG, viewTeamTwo.getText() + " Picked in game: " + gID);
                break;
        }
    }
}
