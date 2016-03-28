package com.daweber.brackets.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daweber.brackets.R;

/**
 * Game View Holder class
 */
public class GameViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "b64.GameViewHolder";

    protected ResizeTextView viewTeamOne, viewTeamTwo, viewGameDetails;
    protected TextView viewBracketRegion;
    protected ImageView pickTeamOne, pickTeamTwo;

    public GameCardClickListener mListener;

    protected int gameID;
    protected int pickID;
    protected int picksetID;

    public GameViewHolder(View v, GameCardClickListener listener) {
        super(v);

        mListener = listener;

        viewTeamOne = (ResizeTextView) v.findViewById(R.id.team_one);
        pickTeamOne = (ImageView) v.findViewById(R.id.team_one_pick);

        viewTeamTwo = (ResizeTextView) v.findViewById(R.id.team_two);
        pickTeamTwo = (ImageView) v.findViewById(R.id.team_two_pick);

        viewGameDetails = (ResizeTextView) v.findViewById(R.id.game_details);
        viewBracketRegion = (TextView) v.findViewById(R.id.bracket_region);

        viewTeamOne.setOnClickListener(this);
        viewTeamTwo.setOnClickListener(this);

        pickTeamOne.setOnClickListener(this);
        pickTeamTwo.setOnClickListener(this);

        viewGameDetails.setOnClickListener(this);
        viewBracketRegion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.team_one || id == R.id.team_two)
            mListener.setPicked((ResizeTextView) v, gameID, picksetID, pickID);
        else
            mListener.moreInfo(v, gameID);
    }

    public interface GameCardClickListener {

        void setPicked(ResizeTextView picked, int game, int pickset, int pick);

        void moreInfo(View touched, int game);
    }
}
