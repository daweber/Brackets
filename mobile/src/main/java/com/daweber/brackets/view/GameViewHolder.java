package com.daweber.brackets.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.daweber.brackets.R;

/**
 * Game ViewHolder class
 */
public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    protected ResizeTextView viewTeamOne, viewTeamTwo, viewGameDetails;
    protected TextView viewBracketRegion;

    public GameViewHolder(View v) {
        super(v);
        viewTeamOne = (ResizeTextView) v.findViewById(R.id.team_one);
        viewTeamTwo = (ResizeTextView) v.findViewById(R.id.team_two);
        viewGameDetails = (ResizeTextView) v.findViewById(R.id.game_details);
        viewBracketRegion = (TextView) v.findViewById(R.id.bracket_region);
    }

    @Override
    public void onClick(View v) {

    }
}
